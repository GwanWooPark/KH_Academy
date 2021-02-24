package com.member.dao;

import com.member.dto.MemberDto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.member.db.JDBCTemplate.*;

//Dao : Data Access Object
// db와 연결하는 코드만 작성


public class MemberDao {

    public List<MemberDto> selectList() {

        // 1.
        // 2.
        // Connection con = JDBCTemplate.getConnection(); <-- import static 클래스 이름 생략 가능
        Connection con = getConnection();

        // 3.
        String sql = " SELECT M_NO, M_NAME, M_AGE, M_GENDER, M_LOCATION, M_JOB, M_TEL, M_EMAIL" +
                " FROM MEMBER " +
                " ORDER BY M_NO DESC ";

        Statement stmt = null;
        ResultSet rs = null;

        List<MemberDto> list = new ArrayList<MemberDto>();

        try {
            stmt = con.createStatement();

            // 4.
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                MemberDto dto = new MemberDto();
                dto.setM_no(rs.getInt(1));
                dto.setM_name(rs.getString(2));
                dto.setM_age(rs.getInt(3));
                dto.setM_gender(rs.getString(4));
                dto.setM_location(rs.getString(5));
                dto.setM_job(rs.getString(6));
                dto.setM_tel(rs.getString(7));
                dto.setM_email(rs.getString(8));

                list.add(dto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(rs);
            close(stmt);
            close(con);
        }
        // 5.

        return list;
    }

    // 선택 출력
    public MemberDto selectOne(int m_no) { // dto를 이용하여 1 row를 리턴한다.

        // 1.
        // 2.
        Connection con = getConnection();

        // 3.
        String sql = " SELECT M_NO, M_NAME, M_AGE, M_GENDER, M_LOCATION, M_JOB, M_TEL, M_EMAIL" +
                " FROM MEMBER " +
                " WHERE M_NO = " + m_no;

        Statement stmt = null;
        ResultSet rs = null;

        MemberDto dto = new MemberDto();
        try {
            stmt = con.createStatement();

            // 4.
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                dto.setM_no(rs.getInt(1));
                dto.setM_name(rs.getString(2));
                dto.setM_age(rs.getInt(3));
                dto.setM_gender(rs.getString(4));
                dto.setM_location(rs.getString(5));
                dto.setM_job(rs.getString(6));
                dto.setM_tel(rs.getString(7));
                dto.setM_email(rs.getString(8));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(rs);
            close(stmt);
            close(con);
        }
        return dto;
    }

    // 추가
    public int insert(MemberDto dto) {

        // 1.
        // 2.
        Connection con = getConnection();

        // 3.
        String sql = " INSERT INTO MEMBER " +
                     " VALUES (MEMBERSEQ.NEXTVAL, ?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement pstm = null;
        int res = 0;

        try {
            pstm = con.prepareStatement(sql);
            pstm.setString(1, dto.getM_name());
            pstm.setInt(2, dto.getM_age());
            pstm.setString(3, dto.getM_gender());
            pstm.setString(4, dto.getM_location());
            pstm.setString(5, dto.getM_job());
            pstm.setString(6, dto.getM_tel());
            pstm.setString(7, dto.getM_email());

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

        return res;
    }

    // 수정
    public int update(MemberDto dto) {
// 1.
        // 2.
        Connection con = getConnection();

        // 3.
        String sql = " UPDATE MEMBER "
                    + " SET M_NAME = ?, M_AGE = ?, M_GENDER = ?, M_LOCATION = ?, M_JOB = ?, M_TEL = ?, M_EMAIL = ?"
                    + " WHERE M_NO =  " + dto.getM_no(); // WHERE M_NO = ?로 하면 마지막에 setInt해야함.

        PreparedStatement pstm = null;
        int res = 0;

        try {
            pstm = con.prepareStatement(sql);
            pstm.setString(1, dto.getM_name());
            pstm.setInt(2, dto.getM_age());
            pstm.setString(3, dto.getM_gender());
            pstm.setString(4, dto.getM_location());
            pstm.setString(5, dto.getM_job());
            pstm.setString(6, dto.getM_tel());
            pstm.setString(7, dto.getM_email());

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

        return res;
    }

    // 삭제
    public int delete(int m_no) {


        // 1.
        // 2.
        Connection con = getConnection();

        String sql = " DELETE FROM MEMBER "
                + " WHERE M_NO = " + m_no;

        PreparedStatement pstm = null;
        int res = 0;

        try {
            pstm = con.prepareStatement(sql);

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
        return res;
    }
}