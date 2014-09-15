package com.google.appengine.rssify.servlets;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.rssify.fetchers.Configuration;
import com.google.appengine.rssify.model.SourceConfiguration;
import com.google.appengine.rssify.model.SourceItem;
import com.google.appengine.rssify.services.DatabaseService;
import com.google.appengine.rssify.utils.FeedUtils;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.io.FeedException;
import com.sun.syndication.io.SyndFeedOutput;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by gianluca on 9/13/14.
 */
public class RssServlet extends HttpServlet {
    private static final Logger log = Logger.getLogger(RssServlet.class.getName());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String sourceConfigurationId = req.getPathInfo();
        log.info("Received " + sourceConfigurationId);
        SourceConfiguration sourceConfiguration = Configuration.sourceConfigurations.get(sourceConfigurationId);
        if (sourceConfiguration == null) {
            log.severe("Wrong resource " + req.getPathInfo());
            resp.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        List<SourceItem> items = DatabaseService.getItems(sourceConfigurationId, 25);
        SyndFeed feed = FeedUtils.createFeed(sourceConfigurationId, sourceConfiguration, items);

        SyndFeedOutput output = new SyndFeedOutput();
        resp.setCharacterEncoding("UTF-8");
        PrintWriter writer = resp.getWriter();

        try {
            output.output(feed, writer);
        } catch (FeedException e) {
            e.printStackTrace();
        }

        writer.close();
    }
}
