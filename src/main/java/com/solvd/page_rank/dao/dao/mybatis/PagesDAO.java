package com.solvd.page_rank.dao.dao.mybatis;

import com.solvd.page_rank.dao.IPagesDAO;
import com.solvd.page_rank.models.Pages;

import java.util.List;

public class PagesDAO extends AbstractDAO<IPagesDAO> implements IPagesDAO{

    @Override
    public Pages getEntity(int id) {
        setMapper();
        Pages page = mapper.getEntity(id);
        closeSession();
        return page;
    }

    @Override
    public List<Pages> getAllEntity() {
        setMapper();
        List<Pages> pages= mapper.getAllEntity();
        closeSession();
        return pages;
    }

    @Override
    public void createEntity(Pages page) {
        setMapper();
        mapper.createEntity(page);
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
    public void deleteEntity(int id) {
        setMapper();
        mapper.deleteEntity(id);
        session.commit();
        closeSession();
    }

    @Override
    public void setMapper() {
        openSession();
        mapper = session.getMapper(IPagesDAO.class);
    }
}
