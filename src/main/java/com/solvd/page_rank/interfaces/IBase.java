package com.solvd.page_rank.interfaces;

import java.util.List;

public interface IBase  <T>{
    T getEntity(long id);

    List<T> getAllEntity();

    void createEntity(T t);

    void updateEntity(T t);

    void deleteEntity(long id);
}