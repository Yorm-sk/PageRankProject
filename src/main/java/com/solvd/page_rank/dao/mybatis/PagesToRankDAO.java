package com.solvd.page_rank.dao.mybatis;

import com.solvd.page_rank.dao.IPagesToRankDAO;
import com.solvd.page_rank.models.PagesToRank;

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
    public List<PagesToRank> getAllEntity() {
        setMapper();
        List<PagesToRank> pagesToRanks= mapper.getAllEntity();
        closeSession();
        return pagesToRanks;
    }

    @Override
    public void createEntity(PagesToRank pageToRank) {
        setMapper();
        mapper.createEntity(pageToRank);
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
    public void deleteEntity(int id) {
        setMapper();
        mapper.deleteEntity(id);
        session.commit();
        closeSession();
    }

    @Override
    public void setMapper() {
        openSession();
        mapper = session.getMapper(IPagesToRankDAO.class);
    }
}
