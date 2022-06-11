package com.solvd.page_rank.dao;

import com.solvd.page_rank.interfaces.IRelationsBetweenPagesDAO;
import com.solvd.page_rank.models.PagesToRank;
import com.solvd.page_rank.models.RelationsBetweenPages;
import com.solvd.page_rank.models.Users;

import java.util.List;

public class RelationsBetweenPagesDAO extends AbstractDAO<IRelationsBetweenPagesDAO> implements IRelationsBetweenPagesDAO{

    @Override
    public RelationsBetweenPages getEntity(long id) {
        setMapper();
        RelationsBetweenPages relationBetweenPages = mapper.getEntity(id);
        closeSession();
        return relationBetweenPages;
    }

    @Override
    public List<RelationsBetweenPages> getAllEntity() {
        setMapper();
        List<RelationsBetweenPages> relationsBetweenPages= mapper.getAllEntity();
        closeSession();
        return relationsBetweenPages;
    }

    @Override
    public void createEntity(RelationsBetweenPages relationBetweenPages) {
        setMapper();
        mapper.createEntity(relationBetweenPages);
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
    public void deleteEntity(long id) {
        setMapper();
        mapper.deleteEntity(id);
        session.commit();
        closeSession();
    }

    @Override
    public void setMapper() {
        openSession();
        mapper = session.getMapper(IRelationsBetweenPagesDAO.class);
    }
}
