package com.solvd.page_rank.dao;

import com.solvd.page_rank.models.PagesToRank;
import com.solvd.page_rank.models.Users;

import java.util.List;

public class PagesToRankDAO extends AbstractDAO<IPagesToRankDAO> implements IPagesToRankDAO{
    @Override
    public PagesToRank getEntity(int id) {
        setMapper();
        PagesToRank pageToRank= mapper.getEntity(id);
        closeSession();
        return pageToRank;
    }

    @Override
    public void createEntity(PagesToRank pageToRank) {
        setMapper();
        mapper.createEntity(pageToRank);
        session.commit();
        closeSession();
    }

    @Override
    public void deleteEntity(PagesToRank pageToRank) {
        setMapper();
        mapper.deleteEntity(pageToRank);
        session.commit();
        closeSession();
    }

    @Override
    public void updateEntity(PagesToRank pageToRank) {
        setMapper();
        mapper.updateEntity(pageToRank);
        session.commit();
        closeSession();
    }

    @Override
    public List<PagesToRank> getPagesToRank() {
        setMapper();
        List<PagesToRank> pagesToRanks= mapper.getPagesToRank();
        closeSession();
        return pagesToRanks;
    }

    @Override
    public void setMapper() {
        openSession();
        mapper = session.getMapper(IPagesToRankDAO.class);
    }
}
