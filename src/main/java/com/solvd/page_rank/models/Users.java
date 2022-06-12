package com.solvd.page_rank.models;

import java.util.List;

public class Users {
    private int id;
    private String login;
    private String password;
    public Users() {
    }

    public Users(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public Users(int id, String login, String password) {
        this.id = id;
        this.login = login;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    @Override
    public String toString() {
        return "Pages{" +
                "id=" + id + "\n" +
                "login=" + login + '\'' + "\n" +
                "password=" + password +
                '}';
    }
}
