package com.join.dao;

import com.join.dto.JoinDto;

import java.util.List;

public interface JoinDao {

    String SELECT_ALL_SQL = " SELECT M_NO, M_NAME, M_AGE, M_GENDER, M_LOCATION, M_JOB, M_TEL, M_EMAIL, S_KOR, S_ENG, S_MATH, S_SUM, S_AVG, S_GRADE " +
                            " FROM MEMBER JOIN SCORE ON M_NAME = S_NAME ";

    String SELECT_ONE_SQL = " SELECT M_NO, M_NAME, M_AGE, M_GENDER, M_LOCATION, M_JOB, M_TEL, M_EMAIL, S_KOR, S_ENG, S_MATH, S_SUM, S_AVG, S_GRADE " +
                            " FROM MEMBER JOIN SCORE ON M_NAME = S_NAME " +
                            " WHERE M_NO = ? ";

    String SELECT_INSERT_SQL = " ";

    String SELECT_UPDATE_SQL = "  ";

    String SELECT_DELETE_SQL = "  ";

    String TOP_N_SQL =
            "SELECT * " +
            "FROM(SELECT M_NO, M_NAME, M_AGE, M_GENDER, M_LOCATION, M_JOB, M_TEL, M_EMAIL, S_KOR, S_ENG, S_MATH, S_SUM, S_AVG, S_GRADE, ROWNUM AS R " +
            "     FROM (SELECT M_NO, M_NAME, M_AGE, M_GENDER, M_LOCATION, M_JOB, M_TEL, M_EMAIL, S_KOR, S_ENG, S_MATH, S_SUM, S_AVG, S_GRADE  " +
            "           FROM MEMBER " +
            "               JOIN SCORE ON M_NAME = S_NAME " +
            "           ORDER BY S_AVG DESC " +
            "         ) A " +
            "    )B " +
            "WHERE R = ?";

    public List<JoinDto> selectList();

    public JoinDto selectOne(int m_no);

    public int insert(JoinDto dto);

    public int update(JoinDto dto);

    public int delete(int m_no);

    public JoinDto topNproc(int n);
}
