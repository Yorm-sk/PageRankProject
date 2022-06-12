package com.solvd.page_rank.dao;

import com.solvd.page_rank.interfaces.ISettingsForAlgorythmDAO;
import com.solvd.page_rank.models.SettingsForAlgorythm;

import java.util.List;

public class SettingsForAlgorythmDAO extends AbstractDAO<ISettingsForAlgorythmDAO> implements ISettingsForAlgorythmDAO {

    @Override
    public SettingsForAlgorythm getEntity(int id) {
        setMapper();
        SettingsForAlgorythm settingForAlgorythm = mapper.getEntity(id);
        closeSession();
        return settingForAlgorythm;
    }

    @Override
    public List<SettingsForAlgorythm> getAllEntity() {
        setMapper();
        List<SettingsForAlgorythm> settingsForAlgorythm = mapper.getAllEntity();
        closeSession();
        return settingsForAlgorythm;
    }

    @Override
    public void createEntity(SettingsForAlgorythm settingForAlgorythm) {
        setMapper();
        mapper.createEntity(settingForAlgorythm);
        session.commit();
        closeSession();
    }

    @Override
    public void updateEntity(SettingsForAlgorythm settingForAlgorythm) {
        setMapper();
        mapper.updateEntity(settingForAlgorythm);
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
        mapper = session.getMapper(ISettingsForAlgorythmDAO.class);
    }

    @Override
    public SettingsForAlgorythm getSettingsByUserID(int userId) {
        setMapper();
        SettingsForAlgorythm settings = mapper.getSettingsByUserID(userId);
        closeSession();
        return settings;
    }
}
