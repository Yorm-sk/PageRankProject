package com.solvd.page_rank.models;

public class PagesToRank {
    private int id;
    private Users user;
    private Pages page;
    private double rank;

    public PagesToRank() {
    }

    public PagesToRank(Users user, Pages page, double rank) {
        this.user = user;
        this.page = page;
        this.rank = rank;
    }

    public PagesToRank(int id, Users user, Pages page, double rank) {
        this.id = id;
        this.user = user;
        this.page = page;
        this.rank = rank;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public Pages getPage() {
        return page;
    }

    public void setPage(Pages page) {
        this.page = page;
    }

    public double getRank() {
        return rank;
    }

    public void setRank(double rank) {
        this.rank = rank;
    }



    @Override
    public String toString() {
        return "Pages{" +
                "id=" + id + "\n" +
                "user=" + user + '\'' + "\n" +
                "page=" + page + '\'' + "\n" +
                "rank=" + rank +
                '}';
    }
}
