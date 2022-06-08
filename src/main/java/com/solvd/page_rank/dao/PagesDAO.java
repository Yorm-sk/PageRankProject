package com.solvd.page_rank.dao;

import com.solvd.page_rank.models.Pages;
import com.solvd.page_rank.models.Users;

import java.util.List;

public class PagesDAO extends AbstractDAO<IPagesDao> implements IPagesDao{
    @Override
    public Pages getEntity(int id) {
        setMapper();
        Pages page = mapper.getEntity(id);
        closeSession();
        return page;
    }

    @Override
    public void createEntity(Pages page) {
        setMapper();
        mapper.createEntity(page);
        session.commit();
        closeSession();
    }

    @Override
    public void deleteEntity(Users user) {
        setMapper();
        mapper.deleteEntity(user);
        session.commit();
        closeSession();
    }

    @Override
    public void updateEntity(Pages page) {
        setMapper();
        mapper.updateEntity(page);
        session.commit();
        closeSession();
    }

    @Override
    public List<Pages> getUsers() {
        setMapper();
        List<Pages> pages= mapper.getPages();
        closeSession();
        return pages;
    }

    @Override
    public void setMapper() {
        openSession();
        mapper = session.getMapper(IPagesDao.class);
    }
}
