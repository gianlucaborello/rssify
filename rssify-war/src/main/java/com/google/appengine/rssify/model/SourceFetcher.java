package com.google.appengine.rssify.model;

import java.io.IOException;
import java.util.List;

/**
 * Created by gianluca on 9/13/14.
 */
public interface SourceFetcher {
    public List<SourceItem> fetchItems() throws IOException;
}
