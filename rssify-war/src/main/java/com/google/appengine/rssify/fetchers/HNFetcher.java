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
        Elements subtexts = doc.select(".subtext");
        articles.remove(articles.size() - 1);

        if (articles.size() != subtexts.size()) {
            log.severe("Got " + articles.size() + " articles and " + subtexts.size() + " subtexts");
            return null;
        }

        log.info("Got " + articles.size() + " items ");

        List<SourceItem> sourceItems = new ArrayList<SourceItem>();

        for (int j = 0; j < articles.size(); ++j) {
            Element article = articles.get(j);

            Elements comments = subtexts.get(j).select("a:eq(2)");
            if (comments.isEmpty()) {
                log.info("Empty comments for item " + article.attr("href"));
                continue;
            }
            Element comment = comments.get(0);

            Elements points = subtexts.get(j).select("span");
            if (points.isEmpty()) {
                log.info("Empty points for item " + article.attr("href"));
                continue;
            }
            Element point = points.get(0);

            switch (ranking) {
                case BY_COMMENTS:
                    if (!comment.text().contains(" ")) {
                        log.info("No comments for item " + article.attr("href"));
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

            String body = "<a href=\"http://news.ycombinator.com/" + comment.attr("href") + "\">" + comment.text() + "</a>&nbsp;<br>" + point.text();
            SourceItem sourceItem = new SourceItem(link,
                    article.text(), body, System.currentTimeMillis());

            sourceItems.add(sourceItem);
        }

        log.info("Returning " + sourceItems.size() + " items");
        return sourceItems;
    }
}
