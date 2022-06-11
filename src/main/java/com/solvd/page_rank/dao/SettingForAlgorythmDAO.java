package com.solvd.page_rank.dao;

import com.solvd.page_rank.interfaces.ISettingForAlgorythmDAO;
import com.solvd.page_rank.models.SettingForAlgorythm;

import java.util.List;

public class SettingForAlgorythmDAO extends AbstractDAO<ISettingForAlgorythmDAO> implements ISettingForAlgorythmDAO{

    @Override
    public SettingForAlgorythm getEntity(long id) {
        setMapper();
        SettingForAlgorythm settingForAlgorythm = mapper.getEntity(id);
        closeSession();
        return settingForAlgorythm;
    }

    @Override
    public List<SettingForAlgorythm> getAllEntity() {
        setMapper();
        List<SettingForAlgorythm> settingsForAlgorythm = mapper.getAllEntity();
        closeSession();
        return settingsForAlgorythm;
    }

    @Override
    public void createEntity(SettingForAlgorythm settingForAlgorythm) {
        setMapper();
        mapper.createEntity(settingForAlgorythm);
        session.commit();
        closeSession();
    }

    @Override
    public void updateEntity(SettingForAlgorythm settingForAlgorythm) {
        setMapper();
        mapper.updateEntity(settingForAlgorythm);
        session.commit();
        closeSession();
    }

    @Override
    public void deleteEntity(long id) {
        setMapper();
        mapper.deleteEntity(id);
        session.commit();
        closeSession();
    }

    @Override
    public void setMapper() {
        openSession();
        mapper = session.getMapper(ISettingForAlgorythmDAO.class);
    }
}
