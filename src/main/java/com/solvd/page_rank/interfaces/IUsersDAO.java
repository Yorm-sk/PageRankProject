package com.solvd.page_rank.interfaces;

import com.solvd.page_rank.models.Users;

public interface IUsersDAO extends IBaseDAO<Users> {
    Users getUserByLogin(String login);
}
