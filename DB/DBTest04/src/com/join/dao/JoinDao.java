package com.join.dao;

import com.join.dto.JoinDto;

import java.util.List;

public interface JoinDao {

    String SELECT_ALL_SQL = " SELECT M_NO, M_NAME, M_AGE, M_GENDER, M_LOCATION, M_JOB, M_TEL, M_EMAIL, S_KOR, S_ENG, S_MATH, S_SUM, S_AVG, S_GRADE " +
                            " FROM MEMBER JOIN SCORE ON M_NAME = S_NAME ";

    String SELECT_ONE_SQL = " SELECT M_NO, M_NAME, M_AGE, M_GENDER, M_LOCATION, M_JOB, M_TEL, M_EMAIL, S_KOR, S_ENG, S_MATH, S_SUM, S_AVG, S_GRADE " +
                            " FROM MEMBER JOIN SCORE ON M_NAME = S_NAME " +
                            " WHERE M_NO = ? ";

    String SELECT_SCORE_INSERT_SQL = " INSERT INTO SCORE " +
                                     " VALUES ( ?, ? ,? ,? ,? ,?, ? ) ";

    String SELECT_SCORE_UPDATE_SQL = " UPDATE SCORE " +
                                     " SET S_NAME = ?, S_KOR = ?, S_ENG = ?, S_MATH = ?, S_SUM = ?, S_AVG = ?, S_GRADE = ? " +
                                     " WHERE S_NAME = ? ";

    String SELECT_SCORE_DELETE_SQL = " DELETE FROM SCORE " +
                                     " WHERE S_NAME = ? ";

    String SELECT_MEMBER_INSERT_SQL = " INSERT INTO MEMBER " +
                                      " VALUES (MEMBERSEQ.NEXTVAL, ?, ? ,? ,? ? ,?, ?)";

    String SELECT_MEMBER_UPDATE_SQL = " UPDATE MEMBER " +
                                      " SET M_NAME = ?, M_AGE = ?, M_GENDER = ?, M_LOCATION = ?, M_JOB = ?, M_TEL = ?, M_EMAIL = ?" +
                                      " WHERE M_NAME = ? ";

    String SELECT_MEMBER_DELETE_SQL = " DELETE FROM MEMBER " +
                                      " WHERE M_NAME = ? ";

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

    public int insertScore(JoinDto dto);

    public int updateScore(JoinDto dto);

    public int deleteScore(String name);

    public int insertMember(JoinDto dto);

    public int updateMember(JoinDto dto);

    public int deleteMember(String name);

    public JoinDto topNproc(int n);
}
