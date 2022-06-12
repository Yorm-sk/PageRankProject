package com.solvd.page_rank.interfaces;

import com.solvd.page_rank.models.SettingsForAlgorythm;

public interface ISettingsForAlgorythmDAO extends IBaseDAO<SettingsForAlgorythm> {
    SettingsForAlgorythm getSettingsByUserID(int userId);
}
