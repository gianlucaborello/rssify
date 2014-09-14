package com.google.appengine.rssify.fetchers;

import com.google.appengine.rssify.model.SourceFetcher;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by gianluca on 9/13/14.
 */
public class Fetchers {
    public static Map<String, SourceFetcher> fetchers = new HashMap<String, SourceFetcher>()
    {{
            put("askhn10", new HNFetcher(10));
    }};
}
