package com.google.appengine.rssify.model;

/**
 * Created by gianluca on 9/13/14.
 */
public class SourceConfiguration {
    private String title;
    private String description;
    private SourceFetcher sourceFetcher;

    public SourceConfiguration(String title, String description, SourceFetcher sourceFetcher) {
        this.title = title;
        this.description = description;
        this.sourceFetcher = sourceFetcher;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public SourceFetcher getSourceFetcher() {
        return sourceFetcher;
    }

    public void setSourceFetcher(SourceFetcher sourceFetcher) {
        this.sourceFetcher = sourceFetcher;
    }

    @Override
    public String toString() {
        return "SourceConfiguration{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", sourceFetcher=" + sourceFetcher +
                '}';
    }
}
