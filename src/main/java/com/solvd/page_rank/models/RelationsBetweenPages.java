package com.solvd.page_rank.models;

public class RelationsBetweenPages {
    private int id;
    private PagesToRank pageToRankId1;
    private PagesToRank pageToRankId2;

    public RelationsBetweenPages() {
    }

    public RelationsBetweenPages(PagesToRank pageToRankId1, PagesToRank pageToRankId2) {
        this.pageToRankId1 = pageToRankId1;
        this.pageToRankId2 = pageToRankId2;
    }

    public RelationsBetweenPages(int id, PagesToRank pageToRankId1, PagesToRank pageToRankId2) {
        this.id = id;
        this.pageToRankId1 = pageToRankId1;
        this.pageToRankId2 = pageToRankId2;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public PagesToRank getPageToRankId1() {
        return pageToRankId1;
    }

    public void setPageToRankId1(PagesToRank pageToRankId1) {
        this.pageToRankId1 = pageToRankId1;
    }

    public PagesToRank getPageToRankId2() {
        return pageToRankId2;
    }

    public void setPageToRankId2(PagesToRank user) {
        this.pageToRankId2 = pageToRankId2;
    }

    @Override
    public String toString() {
        return "Pages{" +
                "id=" + id + "\n" +
                "page to rank 1=" + pageToRankId1 + '\'' + "\n" +
                "page to rank 2=" + pageToRankId2 +
                '}';
    }
}
