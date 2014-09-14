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
    public enum Section {
        FRONT,
        SHOW,
        ASK
    }

    public enum Ranking {
        BY_POINTS,
        BY_COMMENTS
    }

    private static final Logger log = Logger.getLogger(HNFetcher.class.getName());

    private Section section;
    private Ranking ranking;
    private int threshold;

    public HNFetcher(int threshold, Section section, Ranking ranking) {
        this.threshold = threshold;
        this.section = section;
        this.ranking = ranking;
    }

    @Override
    public List<SourceItem> fetchItems() throws IOException {
        String url = null;
        switch (section) {
            case FRONT:
                url = "http://news.ycombinator.com";
                break;
            case ASK:
                url = "http://news.ycombinator.com/ask";
                break;
            case SHOW:
                url = "http://news.ycombinator.com/show";
                break;
        }

        Document doc = Jsoup.connect(url).get();
        Elements articles = doc.select(".title a");
        Elements comments = doc.select(".subtext a:eq(2)");
        Elements points = doc.select(".subtext span");
        articles.remove(articles.size() - 1);

        if (articles.size() != comments.size()) {
            log.severe("Got " + articles.size() + " articles and " + comments.size() + " comments");
            return null;
        }

        if (articles.size() != points.size()) {
            log.severe("Got " + articles.size() + " articles and " + points.size() + " points");
            return null;
        }

        log.info("Got " + articles.size() + " items ");

        List<SourceItem> sourceItems = new ArrayList<SourceItem>();

        for (int j = 0; j < comments.size(); ++j) {
            Element comment = comments.get(j);
            Element point = points.get(j);

            switch (ranking) {
                case BY_COMMENTS:
                    if (!comment.text().contains(" ")) {
                        continue;
                    }

                    int numComments = Integer.parseInt(comment.text().split(" ")[0]);
                    if (numComments < threshold) {
                        continue;
                    }
                    break;
                case BY_POINTS:
                    int numPoints = Integer.parseInt(point.text().split(" ")[0]);
                    if (numPoints < threshold) {
                        continue;
                    }
                    break;
            }

            Element article = articles.get(j);

            String link = null;
            switch (section) {
                case FRONT:
                case SHOW:
                    link = article.attr("href");
                    break;
                case ASK:
                    link = "http://news.ycombinator.com/" + article.attr("href");
                    break;
            }

            String body = "<a href=\"http://news.ycombinator.com/" + comment.attr("href") + "\">" + comment.text() + "</a><br>" + point.text();
            SourceItem sourceItem = new SourceItem(link,
                    article.text(), body);

            sourceItems.add(sourceItem);
        }

        log.info("Returning " + sourceItems.size() + " items");
        return sourceItems;
    }
}
