package com.solvd.page_rank.jsonParser;

import java.util.List;

public class MySite {
    private String url;
    private List<String> links;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<String> getLinks() {
        return links;
    }

    public void setLinks(List<String> links) {
        this.links = links;
    }

    @Override
    public String toString() {
        return "MySite{" +
                "url='" + url + '\'' +
                ", links=" + links +
                '}';
    }
}
