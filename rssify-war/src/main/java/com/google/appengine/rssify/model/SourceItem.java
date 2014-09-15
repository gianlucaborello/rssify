package com.google.appengine.rssify.model;

/**
 * Created by gianluca on 9/13/14.
 */
public class SourceItem {
    private String url;
    private String title;
    private String body;
    private Long tsMs;

    public SourceItem(String url, String title, String body, Long tsMs) {
        this.url = url;
        this.title = title;
        this.body = body;
        this.tsMs = tsMs;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Long getTsMs() {
        return tsMs;
    }

    public void setTsMs(Long tsMs) {
        this.tsMs = tsMs;
    }

    @Override
    public String toString() {
        return "SourceItem{" +
                "url='" + url + '\'' +
                ", title='" + title + '\'' +
                ", body='" + body + '\'' +
                ", tsMs=" + tsMs +
                '}';
    }
}
