package com.google.appengine.rssify.servlets;

import com.google.appengine.rssify.fetchers.Fetchers;
import com.google.appengine.rssify.model.SourceFetcher;
import com.google.appengine.rssify.model.SourceItem;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by gianluca on 9/13/14.
 */
public class RssServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        for (SourceFetcher fetcher: Fetchers.fetchers.values()) {
            List<SourceItem> items = fetcher.fetchItems();
            resp.getWriter().println(items);
        }
    }
}
