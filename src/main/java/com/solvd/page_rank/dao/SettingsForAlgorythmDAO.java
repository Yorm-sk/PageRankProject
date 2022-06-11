//package com.solvd.page_rank.dao;
//
//import com.solvd.page_rank.models.Users;
//
//import java.util.List;
//
//public class SettingsForAlgorythmDAO extends AbstractDAO<ISettingsForAlgorythmDao> implements ISettingsForAlgorythmDao{
//    @Override
//    public SettingsForAlgorythmDAO getEntity(int id) {
//        setMapper();
//        SettingsForAlgorythmDAO settingForAlgorythmDAO = mapper.getEntity(id);
//        closeSession();
//        return settingForAlgorythmDAO;
//    }
//
//    @Override
//    public void createEntity(SettingsForAlgorythmDAO settingForAlgorythmDAO) {
//        setMapper();
//        mapper.createEntity(settingForAlgorythmDAO);
//        session.commit();
//        closeSession();
//    }
//
//    @Override
//    public void deleteEntity(SettingsForAlgorythmDAO settingForAlgorythmDAO) {
//        setMapper();
//        mapper.deleteEntity(settingForAlgorythmDAO);
//        session.commit();
//        closeSession();
//    }
//
//    @Override
//    public void updateEntity(SettingsForAlgorythmDAO settingForAlgorythmDAO) {
//        setMapper();
//        mapper.updateEntity(settingForAlgorythmDAO);
//        session.commit();
//        closeSession();
//    }
//
//    @Override
//    public List<SettingsForAlgorythmDAO> getUsers() {
//        setMapper();
//        List<SettingsForAlgorythmDAO> settingsForAlgorythm = mapper.getSettingsForAlgorythm();
//        closeSession();
//        return settingsForAlgorythm;
//    }
//
//    @Override
//    public void setMapper() {
//        openSession();
//        mapper = session.getMapper(ISettingsForAlgorythmDao.class);
//    }
//}
