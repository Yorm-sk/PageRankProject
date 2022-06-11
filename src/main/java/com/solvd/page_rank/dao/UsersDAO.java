//package com.solvd.page_rank.dao;
//
//import com.solvd.page_rank.models.Users;
//
//import java.util.List;
//
//public class UsersDAO extends AbstractDAO<IUsersDao> implements IUsersDao{
//
//    @Override
//    public Users getEntity(int id) {
//        setMapper();
//        Users user = mapper.getEntity(id);
//        closeSession();
//        return user;
//    }
//
//    @Override
//    public void createEntity(Users user) {
//        setMapper();
//        mapper.createEntity(user);
//        session.commit();
//        closeSession();
//    }
//
//    @Override
//    public void deleteEntity(Users user) {
//        setMapper();
//        mapper.deleteEntity(user);
//        session.commit();
//        closeSession();
//    }
//
//    @Override
//    public void updateEntity(Users user) {
//        setMapper();
//        mapper.updateEntity(user);
//        session.commit();
//        closeSession();
//    }
//
//    @Override
//    public List<Users> getUsers() {
//        setMapper();
//        List<Users> users= mapper.getUsers();
//        closeSession();
//        return users;
//    }
//
//    @Override
//    public void setMapper() {
//        openSession();
//        mapper = session.getMapper(IUsersDao.class);
//    }
//}
