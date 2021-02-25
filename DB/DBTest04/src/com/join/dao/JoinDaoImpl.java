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
    public int insert(JoinDto dto) {

        // 1.
        // 2.
        Connection con = getConnection();

        PreparedStatement pstm = null;
        int res = 0;

        return res;
    }

    @Override
    public int update(JoinDto dto) {
        return 0;
    }

    @Override
    public int delete(int m_no) {
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
