package com.my.dao;
import com.my.dto.MyBoardDto;
import org.apache.ibatis.session.SqlSession;

import java.util.List;


public class MyBoardDao extends SqlMapConfig{

    private String nameSpace = "com.my.mapper.";

    public List<MyBoardDto> selectList() {

        SqlSession session = getSqlSessionFactory().openSession();
        List<MyBoardDto> list = session.selectList("com.my.mapper." + "selectList");
        session.close();

        return list;
    }

    public MyBoardDto selectOne(int myno) {

        SqlSession session = null;
        MyBoardDto dto = null;

        try {
            session = getSqlSessionFactory().openSession();
            dto = session.selectOne(nameSpace + "selectOne", myno);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return dto;
    }

    public int insert(MyBoardDto dto) {

        int res = 0;
        try (SqlSession session = getSqlSessionFactory().openSession(true)) {
            res = session.insert(nameSpace + "insert", dto);
        }

       return res;
    }

    public int update(MyBoardDto dto) {

        int res = 0;
        try (SqlSession session = getSqlSessionFactory().openSession(true)) {
            res = session.insert(nameSpace + "update", dto);
        }

        return res;
    }

    public int delete(int myno) {
        int res = 0;
        try (SqlSession session = getSqlSessionFactory().openSession(true)) {
            res = session.insert(nameSpace + "delete", myno);
        }

        return res;
    }
}
