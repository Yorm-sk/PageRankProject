package com.solvd.page_rank.dao;

import com.solvd.page_rank.dao.IBaseDAO;
import com.solvd.page_rank.models.SettingsForAlgorythm;

public interface ISettingsForAlgorythmDAO extends IBaseDAO<SettingsForAlgorythm> {
    SettingsForAlgorythm getSettingsByUserID(int userId);
}
