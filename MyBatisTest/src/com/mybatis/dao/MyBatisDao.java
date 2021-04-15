package com.mybatis.dao;


import com.mybatis.dto.MyBatisDto;
import com.mybatis.mapper.mapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class MyBatisDao {

    private SqlSession sqlSession;

    public List<MyBatisDto> selectList() {

        mapper mapper = sqlSession.getMapper(com.mybatis.mapper.mapper.class);
        return null;
    }
}
