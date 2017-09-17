package com.google.appengine.rssify.fetchers;

import com.google.appengine.rssify.model.SourceConfiguration;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by gianluca on 9/13/14.
 */
public class Configuration {
    public static final Map<String, SourceConfiguration> sourceConfigurations = new HashMap<String, SourceConfiguration>() {{

        put("/hn10comments", new SourceConfiguration("HN - 10 comments", "Hacker News items with at least 10 comments", new HNFetcher(10, HNFetcher.Section.FRONT, HNFetcher.Ranking.BY_COMMENTS)));
        put("/hn50comments", new SourceConfiguration("HN - 50 comments", "Hacker News items with at least 50 comments", new HNFetcher(50, HNFetcher.Section.FRONT, HNFetcher.Ranking.BY_COMMENTS)));
        put("/hn100comments", new SourceConfiguration("HN - 100 comments", "Hacker News items with at least 100 comments", new HNFetcher(100, HNFetcher.Section.FRONT, HNFetcher.Ranking.BY_COMMENTS)));

        put("/askhn10comments", new SourceConfiguration("Ask HN - 10 comments", "Ask Hacker News items with at least 10 comments", new HNFetcher(10, HNFetcher.Section.ASK, HNFetcher.Ranking.BY_COMMENTS)));
        put("/askhn50comments", new SourceConfiguration("Ask HN - 50 comments", "Ask Hacker News items with at least 50 comments", new HNFetcher(50, HNFetcher.Section.ASK, HNFetcher.Ranking.BY_COMMENTS)));
        put("/askhn100comments", new SourceConfiguration("Ask HN - 100 comments", "Ask Hacker News items with at least 100 comments", new HNFetcher(100, HNFetcher.Section.ASK, HNFetcher.Ranking.BY_COMMENTS)));

        put("/showhn10comments", new SourceConfiguration("Show HN - 10 comments", "Show Hacker News items with at least 10 comments", new HNFetcher(10, HNFetcher.Section.SHOW, HNFetcher.Ranking.BY_COMMENTS)));
        put("/showhn50comments", new SourceConfiguration("Show HN - 50 comments", "Show Hacker News items with at least 50 comments", new HNFetcher(50, HNFetcher.Section.SHOW, HNFetcher.Ranking.BY_COMMENTS)));
        put("/showhn100comments", new SourceConfiguration("Show HN - 100 comments", "Show Hacker News items with at least 100 comments", new HNFetcher(100, HNFetcher.Section.SHOW, HNFetcher.Ranking.BY_COMMENTS)));

        put("/hn10points", new SourceConfiguration("HN - 10 points", "Hacker News items with at least 10 points", new HNFetcher(10, HNFetcher.Section.FRONT, HNFetcher.Ranking.BY_POINTS)));
        put("/hn50points", new SourceConfiguration("HN - 50 points", "Hacker News items with at least 50 points", new HNFetcher(50, HNFetcher.Section.FRONT, HNFetcher.Ranking.BY_POINTS)));
        put("/hn100points", new SourceConfiguration("HN - 100 points", "Hacker News items with at least 100 points", new HNFetcher(100, HNFetcher.Section.FRONT, HNFetcher.Ranking.BY_POINTS)));
        put("/hn250points", new SourceConfiguration("HN - 250 points", "Hacker News items with at least 250 points", new HNFetcher(250, HNFetcher.Section.FRONT, HNFetcher.Ranking.BY_POINTS)));
        put("/hn500points", new SourceConfiguration("HN - 500 points", "Hacker News items with at least 500 points", new HNFetcher(500, HNFetcher.Section.FRONT, HNFetcher.Ranking.BY_POINTS)));

        put("/askhn10points", new SourceConfiguration("Ask HN - 10 points", "Ask Hacker News items with at least 10 points", new HNFetcher(10, HNFetcher.Section.ASK, HNFetcher.Ranking.BY_POINTS)));
        put("/askhn50points", new SourceConfiguration("Ask HN - 50 points", "Ask Hacker News items with at least 50 points", new HNFetcher(50, HNFetcher.Section.ASK, HNFetcher.Ranking.BY_POINTS)));
        put("/askhn100points", new SourceConfiguration("Ask HN - 100 points", "Ask Hacker News items with at least 100 points", new HNFetcher(100, HNFetcher.Section.ASK, HNFetcher.Ranking.BY_POINTS)));

        put("/showhn10points", new SourceConfiguration("Show HN - 10 points", "Show Hacker News items with at least 10 points", new HNFetcher(10, HNFetcher.Section.SHOW, HNFetcher.Ranking.BY_POINTS)));
        put("/showhn50points", new SourceConfiguration("Show HN - 50 points", "Show Hacker News items with at least 50 points", new HNFetcher(50, HNFetcher.Section.SHOW, HNFetcher.Ranking.BY_POINTS)));
        put("/showhn100points", new SourceConfiguration("Show HN - 100 points", "Show Hacker News items with at least 100 points", new HNFetcher(100, HNFetcher.Section.SHOW, HNFetcher.Ranking.BY_POINTS)));

        put("/bogleheads10", new SourceConfiguration("Bogleheads 10", "Bogleheads items with at least 10 comments", new BogleHeadsFetcher(10)));
        put("/bogleheads50", new SourceConfiguration("Bogleheads 50", "Bogleheads items with at least 50 comments", new BogleHeadsFetcher(50)));
        put("/bogleheads100", new SourceConfiguration("Bogleheads 100", "Bogleheads items with at least 100 comments", new BogleHeadsFetcher(100)));
    }};
}
