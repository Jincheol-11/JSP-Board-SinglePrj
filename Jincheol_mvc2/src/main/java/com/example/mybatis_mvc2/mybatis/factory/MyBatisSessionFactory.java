package com.example.mybatis_mvc2.mybatis.factory;

import com.example.mybatis_mvc2.mybatis.config.MyBatisConfig;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class MyBatisSessionFactory {

    private static SqlSessionFactory sqlSessionFactory = null;

    static {
        MyBatisConfig myBatisConfig = new MyBatisConfig();
        sqlSessionFactory = myBatisConfig.getSqlSessionFactory();
    }

    public static SqlSession getSqlSession() { return sqlSessionFactory.openSession(); }
} // getSqlSession을 통해 어디서든지 쓸 수 있도록 함.
