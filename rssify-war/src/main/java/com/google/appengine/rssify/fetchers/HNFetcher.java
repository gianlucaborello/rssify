package com.google.appengine.rssify.fetchers;

import com.google.appengine.rssify.model.SourceFetcher;
import com.google.appengine.rssify.model.SourceItem;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by gianluca on 9/13/14.
 */
public class HNFetcher implements SourceFetcher {
    private static final Logger log = Logger.getLogger(HNFetcher.class.getName());

    private int minComments;

    public HNFetcher(int minComments) {
        this.minComments = minComments;
    }

    @Override
    public List<SourceItem> fetchItems() throws IOException {
        Document doc = Jsoup.connect("http://news.ycombinator.com/ask").get();
        Elements articles = doc.select(".title a:not([rel])");
        Elements comments = doc.select(".subtext a:matches(comment|discuss)");
        if (articles.size() != comments.size()) {
            log.severe("Got " + articles.size() + " articles and " + comments.size() + " comments");
            return null;
        }

        log.info("Got " + articles.size() + " items ");

        List<SourceItem> sourceItems = new ArrayList<SourceItem>();

        for (int j = 0; j < comments.size(); ++j) {
            Element el = comments.get(j);
            if (el.text().contains("discuss")) {
                continue;
            }

            int numComments = Integer.parseInt(el.text().split(" ")[0]);
            if (numComments < minComments) {
                continue;
            }

            Element article = articles.get(j);

            SourceItem sourceItem = new SourceItem("http://news.ycombinator.com/" + article.attr("href"),
                    article.text(), el.text());

            sourceItems.add(sourceItem);
        }

        log.info("Returning " + sourceItems.size() + " items");
        return sourceItems;
    }
}
