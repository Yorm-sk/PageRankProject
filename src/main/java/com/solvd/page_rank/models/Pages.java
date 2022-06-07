package com.solvd.page_rank.models;

public class Pages {
    private int id;
    private String url;
    private Users user;

    public Pages() {
    }

    public Pages(String url, Users user) {
        this.url = url;
        this.user = user;
    }

    public Pages(int id, String url, Users user) {
        this.id = id;
        this.url = url;
        this.user = user;
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

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Pages{" +
                "id=" + id + "\n" +
                "url=" + url + '\'' + "\n" +
                "user=" + user +
                '}';
    }
}
