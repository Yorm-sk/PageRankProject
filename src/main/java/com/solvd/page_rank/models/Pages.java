package com.solvd.page_rank.models;

public class Pages {
    private int id;
    private String url;
    public Pages() {
    }

    public Pages(String url) {
        this.url = url;
    }

    public Pages(int id, String url) {
        this.id = id;
        this.url = url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }


    @Override
    public String toString() {
        return "Pages{" +
                "id=" + id + "\n" +
                "url=" + url +
                '}';
    }
}
