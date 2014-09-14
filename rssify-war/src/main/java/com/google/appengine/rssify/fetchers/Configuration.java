package com.google.appengine.rssify.fetchers;

import com.google.appengine.rssify.model.SourceConfiguration;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by gianluca on 9/13/14.
 */
public class Configuration {
    public static final Map<String, SourceConfiguration> configuredServices = new HashMap<String, SourceConfiguration>() {{

        put("/hn10", new SourceConfiguration("Hacker News 10", "Hacker News items with at least 10 comments", new HNFetcher(10, false)));
        put("/hn50", new SourceConfiguration("Hacker News 50", "Hacker News items with at least 50 comments", new HNFetcher(50, false)));
        put("/hn100", new SourceConfiguration("Hacker News 100", "Hacker News items with at least 100 comments", new HNFetcher(100, false)));

        put("/askhn10", new SourceConfiguration("Ask Hacker News 10", "Ask Hacker News items with at least 10 comments", new HNFetcher(10, true)));
        put("/askhn50", new SourceConfiguration("Ask Hacker News 50", "Ask Hacker News items with at least 50 comments", new HNFetcher(50, true)));
        put("/askhn100", new SourceConfiguration("Ask Hacker News 100", "Ask Hacker News items with at least 100 comments", new HNFetcher(100, true)));

        put("/bogleheads10", new SourceConfiguration("Bogleheads 10", "Bogleheads items with at least 10 comments", new BogleHeadsFetcher(10)));
        put("/bogleheads50", new SourceConfiguration("Bogleheads 50", "Bogleheads items with at least 50 comments", new BogleHeadsFetcher(50)));
        put("/bogleheads100", new SourceConfiguration("Bogleheads 100", "Bogleheads items with at least 100 comments", new BogleHeadsFetcher(100)));
    }};
}
