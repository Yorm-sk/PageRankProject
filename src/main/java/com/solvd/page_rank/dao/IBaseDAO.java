package com.solvd.page_rank.dao;

import java.util.List;

public interface IBaseDAO<T>{
    T getEntity(int id);

    List<T> getAllEntity();

    void createEntity(T t);

    void updateEntity(T t);

    void deleteEntity(int id);
}