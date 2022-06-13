package com.solvd.page_rank.dao;

import com.solvd.page_rank.dao.IBaseDAO;
import com.solvd.page_rank.models.PagesToRank;
import com.solvd.page_rank.models.Users;

import java.util.List;

public interface IUsersDAO extends IBaseDAO<Users> {
    Users getUserByLogin(String login);

    List<PagesToRank> getPagesToRank(int user_id);
}
