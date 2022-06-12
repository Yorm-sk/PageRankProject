package com.solvd.page_rank.dao;

import com.solvd.page_rank.interfaces.IUsersDAO;
import com.solvd.page_rank.models.PagesToRank;
import com.solvd.page_rank.models.Users;

import java.util.List;

public class UsersDAO extends AbstractDAO<IUsersDAO> implements IUsersDAO{

    @Override
    public Users getEntity(int id) {
        setMapper();
        Users user = mapper.getEntity(id);
        closeSession();
        return user;
    }

    @Override
    public List<Users> getAllEntity() {
        setMapper();
        List<Users> users = mapper.getAllEntity();
        closeSession();
        return users;
    }

    @Override
    public void createEntity(Users user) {
        setMapper();
        mapper.createEntity(user);
        session.commit();
        closeSession();
    }

    @Override
    public void updateEntity(Users user) {
        setMapper();
        mapper.updateEntity(user);
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
        mapper = session.getMapper(IUsersDAO.class);
    }

    @Override
    public Users getUserByLogin(String login) {
        setMapper();
        Users user = mapper.getUserByLogin(login);
        closeSession();
        return user;
    }

    @Override
    public List<PagesToRank> getAllPages() {
        setMapper();
        List<PagesToRank> pagesToRanks = mapper.getAllPages();
        closeSession();
        return pagesToRanks;
    }
}