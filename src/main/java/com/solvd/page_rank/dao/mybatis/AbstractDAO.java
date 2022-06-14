package com.solvd.page_rank.dao.mybatis;

import com.solvd.page_rank.myBatis.MyBatisSQLFactory;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class AbstractDAO <T>{
    private static final Logger LOGGER = LogManager.getLogger();

    protected SqlSession session;
    protected T mapper;

    public void openSession(){
        MyBatisSQLFactory factory = MyBatisSQLFactory.newInstance("myBatis/my_batis_configuration.xml");
        session = factory.getFactory().openSession();
    }

    public void closeSession(){
        if (session != null) session.close();
    }

    abstract public void setMapper();
}
