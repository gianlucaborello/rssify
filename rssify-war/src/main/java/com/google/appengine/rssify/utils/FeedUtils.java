package com.google.appengine.rssify.utils;

import com.google.appengine.rssify.model.SourceConfiguration;
import com.google.appengine.rssify.model.SourceItem;
import com.sun.syndication.feed.synd.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by gianluca on 9/13/14.
 */
public class FeedUtils {
    public static SyndFeed createFeed(String sourceConfigurationId, SourceConfiguration configuration, List<SourceItem> items) {
        SyndFeed feed = new SyndFeedImpl();
        feed.setFeedType("rss_2.0");
        feed.setTitle(configuration.getTitle());
        feed.setDescription(configuration.getDescription());
        feed.setLink("http://feeds.feedburner.com" + sourceConfigurationId);
        feed.setPublishedDate(new Date());

        List entries = new ArrayList();

        for (SourceItem item : items) {
            SyndEntry entry = new SyndEntryImpl();
            entry.setTitle(item.getTitle());
            entry.setLink(item.getUrl());
            SyndContent description = new SyndContentImpl();
            description.setType("text/html");
            description.setValue(item.getBody());
            entry.setDescription(description);
            entry.setPublishedDate(new Date(item.getTsMs()));
            entries.add(entry);
        }

        feed.setEntries(entries);

        return feed;
    }
}
