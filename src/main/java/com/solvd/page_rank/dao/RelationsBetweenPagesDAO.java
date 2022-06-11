package com.solvd.page_rank.dao;

import com.solvd.page_rank.models.PagesToRank;
import com.solvd.page_rank.models.RelationsBetweenPages;
import com.solvd.page_rank.models.Users;

import java.util.List;

public class RelationsBetweenPagesDAO extends AbstractDAO<IRelationsBetweenPagesDAO> implements IRelationsBetweenPagesDAO{
    @Override
    public RelationsBetweenPages getEntity(int id) {
        setMapper();
        RelationsBetweenPages relationBetweenPages = mapper.getEntity(id);
        closeSession();
        return relationBetweenPages;
    }

    @Override
    public void createEntity(RelationsBetweenPages relationBetweenPages) {
        setMapper();
        mapper.createEntity(relationBetweenPages);
        session.commit();
        closeSession();
    }

    @Override
    public void deleteEntity(RelationsBetweenPages relationBetweenPages) {
        setMapper();
        mapper.deleteEntity(relationBetweenPages);
        session.commit();
        closeSession();
    }

    @Override
    public void updateEntity(RelationsBetweenPages relationBetweenPages) {
        setMapper();
        mapper.updateEntity(relationBetweenPages);
        session.commit();
        closeSession();
    }

    @Override
    public List<RelationsBetweenPages> getPagesToRank() {
        setMapper();
        List<RelationsBetweenPages> relationsBetweenPages= mapper.getPagesToRank();
        closeSession();
        return relationsBetweenPages;
    }

    @Override
    public void setMapper() {
        openSession();
        mapper = session.getMapper(IRelationsBetweenPagesDAO.class);
    }
}
