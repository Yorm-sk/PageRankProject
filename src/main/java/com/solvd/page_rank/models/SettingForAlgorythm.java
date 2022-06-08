package com.solvd.page_rank.models;

public class SettingForAlgorythm {
    private int id;
    private double dempingFactor;
    private double limitOfDeflect;
    private Users user;

    public SettingForAlgorythm() {
    }

    public SettingForAlgorythm(double dempingFactor, double limitOfDeflect, Users user) {
        this.dempingFactor = dempingFactor;
        this.limitOfDeflect = limitOfDeflect;
        this.user = user;
    }

    public SettingForAlgorythm(int id, double dempingFactor, double limitOfDeflect, Users user) {
        this.id = id;
        this.dempingFactor = dempingFactor;
        this.limitOfDeflect = limitOfDeflect;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getDempingFactor() {
        return dempingFactor;
    }

    public void setDempingFactor(double dempingFactor) {
        this.dempingFactor = dempingFactor;
    }

    public double getLimitOfDeflect() {
        return limitOfDeflect;
    }

    public void setLimitOfDeflect(double limitOfDeflect) {
        this.limitOfDeflect = limitOfDeflect;
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
                "demping factor=" + dempingFactor + '\'' + "\n" +
                "limit of deflect=" + limitOfDeflect + '\'' + "\n" +
                "user=" + user +
                '}';
    }
}
