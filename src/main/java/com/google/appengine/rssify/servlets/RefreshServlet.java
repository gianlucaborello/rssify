package com.google.appengine.rssify.servlets;

import com.google.appengine.rssify.fetchers.Configuration;
import com.google.appengine.rssify.model.SourceConfiguration;
import com.google.appengine.rssify.model.SourceItem;
import com.google.appengine.rssify.services.DatabaseService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

/**
 * Created by gianluca on 9/14/14.
 */
@WebServlet(name = "refresh", value = "/refresh")
public class RefreshServlet extends HttpServlet {
    private static final Logger log = Logger.getLogger(RefreshServlet.class.getName());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        if (req.getHeader("X-AppEngine-Cron") == null) {
            resp.sendError(HttpServletResponse.SC_FORBIDDEN);
            return;
        }

        for (Map.Entry<String, SourceConfiguration> entry : Configuration.sourceConfigurations.entrySet()) {
            log.info("Running " + entry.getKey());
            List<SourceItem> items = entry.getValue().getSourceFetcher().fetchItems();
            if (items == null) {
                log.severe("Fetcher " + entry.getKey() + " returned null");
                continue;
            }

            DatabaseService.saveItems(entry.getKey(), items);

            String urls = "http://www.feedburner.com/fb/a/pingSubmit?bloglink=http://feeds.feedburner.com" + entry.getKey();
            URL url = new URL(urls);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            int responseCode = urlConnection.getResponseCode();
            log.info("Pinging feedburner returned " + responseCode);
        }
    }
}
