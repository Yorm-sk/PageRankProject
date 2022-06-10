package com.solvd.page_rank.jsonParser;

import java.util.ArrayList;
import java.util.List;

public class Site {

    private String url;
    private List<String> links = new ArrayList<>();
    public  Site() {}
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public List<String> getLinks() {
        return links;
    }
    public void setRefs(List<String> links) {
        this.links = links;
    }
}
