package com.join.dao;

import com.join.dto.JoinDto;

import static com.join.db.JDBCTemplate.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JoinDaoImpl implements JoinDao {

    @Override

    public List<JoinDto> selectList() {

        // 1.
        // 2.
        Connection con = getConnection();

        List <JoinDto> list = new ArrayList<JoinDto>();

        // 3.
        Statement stmt = null;
        ResultSet rs = null;

        try {
            stmt = con.createStatement();

            // 4.
            rs = stmt.executeQuery(SELECT_ALL_SQL);

            while (rs.next()) {

                JoinDto dto = new JoinDto();
                dto.setM_no(rs.getInt(1));
                dto.setM_name(rs.getString(2));
                dto.setM_age(rs.getInt(3));
                dto.setM_gender(rs.getString(4));
                dto.setM_location(rs.getString(5));
                dto.setM_job(rs.getString(6));
                dto.setM_tel(rs.getString(7));
                dto.setM_email(rs.getString(8));
                dto.setS_kor(rs.getInt(9));
                dto.setS_eng(rs.getInt(10));
                dto.setS_math(rs.getInt(11));
                dto.setS_sum(rs.getInt(12));
                dto.setS_avg(rs.getDouble(13));
                dto.setS_grade(rs.getString(14));

                list.add(dto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(rs);
            close(stmt);
            close(con);
        }

        return list;
    }

    @Override
    public JoinDto selectOne(int m_no) {

        // 1.
        // 2.
        Connection con = getConnection();

        // 3.
        PreparedStatement pstm = null;
        ResultSet rs = null;

        JoinDto dto = new JoinDto();

        try {
            pstm = con.prepareStatement(SELECT_ONE_SQL);
            pstm.setInt(1, m_no);

            // 4.
            rs = pstm.executeQuery();
            while (rs.next()) {
                dto.setM_no(rs.getInt(1));
                dto.setM_name(rs.getString(2));
                dto.setM_age(rs.getInt(3));
                dto.setM_gender(rs.getString(4));
                dto.setM_location(rs.getString(5));
                dto.setM_job(rs.getString(6));
                dto.setM_tel(rs.getString(7));
                dto.setM_email(rs.getString(8));
                dto.setS_kor(rs.getInt(9));
                dto.setS_eng(rs.getInt(10));
                dto.setS_math(rs.getInt(11));
                dto.setS_sum(rs.getInt(12));
                dto.setS_avg(rs.getDouble(13));
                dto.setS_grade(rs.getString(14));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return dto;
    }

    @Override
    public int insertScore(JoinDto dto) {
        // 1.
        // 2.
        Connection con = getConnection();

        // 3.
        PreparedStatement pstm = null;
        int res = 0;

        try {
            pstm = con.prepareStatement(SELECT_SCORE_INSERT_SQL);

            // 4.
            pstm.setString(1, dto.getS_name());
            pstm.setInt(2, dto.getS_kor());
            pstm.setInt(3, dto.getS_eng());
            pstm.setInt(4, dto.getS_math());
            pstm.setInt(5, dto.getS_sum());
            pstm.setDouble(6, dto.getS_avg());
            pstm.setString(7, dto.getS_grade());

            res = pstm.executeUpdate();

            if (res > 0) {
                commit(con);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(pstm);
            close(con);
        }

        return 0;
    }

    @Override
    public int updateScore(JoinDto dto) {

        // 1.
        // 2.
        Connection con = getConnection();

        // 3.
        PreparedStatement pstm = null;
        int res = 0;

        try {
            pstm = con.prepareStatement(SELECT_SCORE_UPDATE_SQL);
            pstm.setString(1, dto.getS_name());
            pstm.setInt(2, dto.getS_kor());
            pstm.setInt(3, dto.getS_eng());
            pstm.setInt(4, dto.getS_math());
            pstm.setInt(5, dto.getS_sum());
            pstm.setDouble(6, dto.getS_avg());
            pstm.setString(7, dto.getS_grade());
            // 4.
            res = pstm.executeUpdate();

            if (res > 0) {
                commit(con);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

            // 5.
            close(pstm);
            close(con);
        }
        return 0;
    }

    @Override
    public int deleteScore(String name) {

        // 1.
        // 2.
        Connection con = getConnection();

        // 3.
        PreparedStatement pstm = null;
        int res = 0;

        try {
            pstm = con.prepareStatement(SELECT_SCORE_DELETE_SQL);
            pstm.setString(1, name);

            // 4.
            res = pstm.executeUpdate();

            if (res > 0) {
                commit(con);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(pstm);
            close(con);
        }


        return res;
    }

    @Override
    public int insertMember(JoinDto dto) {

        // 1.
        // 2.
        Connection con = getConnection();

        // 3.
        PreparedStatement pstm = null;
        int res = 0;

        try {
            pstm = con.prepareStatement(SELECT_MEMBER_INSERT_SQL);
            pstm.setString(1, dto.getM_name());
            pstm.setInt(2, dto.getM_age());
            pstm.setString(3, dto.getM_gender());
            pstm.setString(4, dto.getM_location());
            pstm.setString(5, dto.getM_job());
            pstm.setString(6, dto.getM_tel());
            pstm.setString(7, dto.getM_email());

            res = pstm.executeUpdate();
            if (res > 0) {
                commit(con);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(pstm);
            close(con);
        }
        return res;
    }

    @Override
    public int updateMember(JoinDto dto) {
        return 0;
    }

    @Override
    public int deleteMember(String name) {
        return 0;
    }

    @Override
    public JoinDto topNproc(int n) {

        // 1.
        // 2.
        Connection con = getConnection();

        // 3.
        PreparedStatement pstm = null;
        ResultSet rs = null;

        JoinDto dto = new JoinDto();

        try {
            pstm = con.prepareStatement(TOP_N_SQL);
            pstm.setInt(1, n);
            // 4.
            rs = pstm.executeQuery();

            while (rs.next()) {
                dto.setM_no(rs.getInt(1));
                dto.setM_name(rs.getString(2));
                dto.setM_age(rs.getInt(3));
                dto.setM_gender(rs.getString(4));
                dto.setM_location(rs.getString(5));
                dto.setM_job(rs.getString(6));
                dto.setM_tel(rs.getString(7));
                dto.setM_email(rs.getString(8));
                dto.setS_kor(rs.getInt(9));
                dto.setS_eng(rs.getInt(10));
                dto.setS_math(rs.getInt(11));
                dto.setS_sum(rs.getInt(12));
                dto.setS_avg(rs.getDouble(13));
                dto.setS_grade(rs.getString(14));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return dto;
    }
}
