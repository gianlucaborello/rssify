package com.google.appengine.rssify.services;

import com.google.appengine.api.datastore.*;
import com.google.appengine.rssify.model.SourceItem;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by gianluca on 9/14/14.
 */
public class DatabaseService {
    private static final Logger log = Logger.getLogger(DatabaseService.class.getName());

    // Delete entries older than one month
    private static final Long ttlMs = 30 * 24 * 3600 * 1000L;

    public static void saveItems(String sourceConfiguration, List<SourceItem> items) {
        DatastoreService datastoreService = DatastoreServiceFactory.getDatastoreService();

        for (SourceItem item : items) {
            Key key = KeyFactory.createKey(sourceConfiguration, item.getUrl());
            Entity entity = null;
            try {
                entity = datastoreService.get(key);
            } catch (EntityNotFoundException e) {
            }

            if (entity != null) {
                log.info("Item " + item.getUrl() + " already present");
                continue;
            }

            log.info("Saving item " + item.getUrl());

            entity = new Entity(key);
            entity.setProperty("ts", System.currentTimeMillis());
            entity.setProperty("title", item.getTitle());
            entity.setProperty("body", item.getBody());
            datastoreService.put(entity);
        }

        purgeItems(datastoreService, sourceConfiguration);
    }

    private static void purgeItems(DatastoreService datastoreService, String sourceConfiguration) {
        Query query = new Query(sourceConfiguration);

        Query.Filter filter = new Query.FilterPredicate("ts", Query.FilterOperator.LESS_THAN, System.currentTimeMillis() - ttlMs);
        query.setFilter(filter);
        PreparedQuery prepare = datastoreService.prepare(query);
        List<Entity> entities = prepare.asList(FetchOptions.Builder.withDefaults());
        for (Entity e : entities) {
            log.info("Deleting " + e.getKey().getName());
            datastoreService.delete(e.getKey());
        }
    }

    public static List<SourceItem> getItems(String sourceConfiguration, int limit) {
        DatastoreService datastoreService = DatastoreServiceFactory.getDatastoreService();

        Query query = new Query(sourceConfiguration);
        query.addSort("ts", Query.SortDirection.DESCENDING);
        PreparedQuery prepare = datastoreService.prepare(query);
        List<Entity> entities = prepare.asList(FetchOptions.Builder.withLimit(limit));
        List<SourceItem> items = new ArrayList<SourceItem>();
        for (Entity e : entities) {
            items.add(new SourceItem(e.getKey().getName(), (String) e.getProperty("title"), (String) e.getProperty("body")));
        }

        log.info("Returning " + items.size() + " items");
        return items;
    }
}
