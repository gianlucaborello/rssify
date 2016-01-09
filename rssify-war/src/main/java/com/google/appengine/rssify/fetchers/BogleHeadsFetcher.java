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
        Elements articles = doc.select("#posts_table td:has(a[href*=viewtopic])");
        Elements comments = doc.select("#posts_table td[style*=text-align:right;]:lt(1)");
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
            Element firstPage = article.children().first();
            Element lastPage = article.children().last();
            String link = lastPage.attr("href");
            int newpostIdx = link.indexOf("&newpost=");
            int startIdx = link.indexOf("&start=");
            String page = "0";
            if (startIdx != -1) {
                page = lastPage.text();
                String start = link.substring(startIdx);
                link = link.substring(0, newpostIdx) + start;
            } else {
                link = link.substring(0, newpostIdx);
            }

            String body = numComments + " comments, page " + page;
            SourceItem sourceItem = new SourceItem(link,
                    firstPage.text(), body, System.currentTimeMillis());

            sourceItems.add(sourceItem);
        }

        log.info("Returning " + sourceItems.size() + " items");
        return sourceItems;
    }
}
