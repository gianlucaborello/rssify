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
public class BogleHeadsFetcher implements SourceFetcher {
    private static final Logger log = Logger.getLogger(HNFetcher.class.getName());
    private int minComments;

    public BogleHeadsFetcher(int minComments) {
        this.minComments = minComments;
    }

    @Override
    public List<SourceItem> fetchItems() throws IOException {
        String url = "http://www.bogleheads.org/";

        Document doc = Jsoup.connect(url).get();
        Elements articles = doc.select("#table_content a[href*=viewtopic]:lt(1)");
        Elements comments = doc.select("#table_content td[align*=right]:lt(1)");
        if (articles.size() != comments.size()) {
            log.severe("Got " + articles.size() + " articles and " + comments.size() + " comments");
            return null;
        }

        log.info("Got " + articles.size() + " items ");

        List<SourceItem> sourceItems = new ArrayList<SourceItem>();

        for (int j = 0; j < comments.size(); ++j) {
            Element comment = comments.get(j);
            int numComments = Integer.parseInt(comment.text());
            if (numComments < minComments) {
                continue;
            }

            Element article = articles.get(j);

            String body = numComments + " comments";
            SourceItem sourceItem = new SourceItem(article.attr("href"),
                    article.text(), body);

            sourceItems.add(sourceItem);
        }

        log.info("Returning " + sourceItems.size() + " items");
        return sourceItems;
    }
}
