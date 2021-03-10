package com.kh.dao;

import com.kh.dto.TestDto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import static com.kh.db.JDBCTemplate.*;

public class TestDao {

    public List<TestDto> selectList() {

        Connection con = getConnection();

        // 3.
        String sql = " SELECT NO, NAME, PHONE, ADDR " +
                     " FROM KHTEST " +
                     " ORDER BY NO DESC";

        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<TestDto> list = new ArrayList<TestDto>();

        try {
            pstm = con.prepareStatement(sql);

            // 4.
            rs = pstm.executeQuery();
            while (rs.next()) {
                TestDto dto = new TestDto();
                dto.setNo(rs.getInt(1));
                dto.setName(rs.getString(2));
                dto.setPhone(rs.getString(3));
                dto.setAddr(rs.getString(4));

                list.add(dto);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {

            // 5.
            close(rs);
            close(pstm);
            close(con);
        }

        return list;
    }

    public TestDto selectOne(int no) {

        // 1, 2.
        Connection con = getConnection();

        String sql = " SELECT NO, NAME, PHONE, ADDR " +
                     " FROM KHTEST " +
                     " WHERE NO = ? ";

        TestDto dto = new TestDto();
        PreparedStatement pstm = null;
        ResultSet rs = null;

        try {
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, no);

            // 3.
            rs = pstm.executeQuery();

            while (rs.next()) {
                dto.setNo(rs.getInt(1));
                dto.setName(rs.getString(2));
                dto.setPhone(rs.getString(3));
                dto.setAddr(rs.getString(4));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(rs);
            close(pstm);
            close(con);
        }
        return dto;
    }
    public int insert(TestDto dto) {

        // 1, 2.
        Connection con = getConnection();

        String sql = " INSERT INTO KHTEST " +
                     " VALUES (?, ?, ?, ?) ";

        PreparedStatement pstm = null;
        int res = 0;
        try {
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, dto.getNo());
            pstm.setString(2, dto.getName());
            pstm.setString(3, dto.getPhone());
            pstm.setString(4, dto.getAddr());

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

    public int update(TestDto dto) {

        // 1, 2.
        Connection con = getConnection();

        // 3.
        String sql = " UPDATE KHTEST " +
                     " SET NO = ?, NAME = ?, PHONE = ?, ADDR = ? " +
                     " WHERE NO = ? ";

        PreparedStatement pstm = null;
        int res = 0;

        try {
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, dto.getNo());
            pstm.setString(2, dto.getName());
            pstm.setString(3, dto.getPhone());
            pstm.setString(4, dto.getAddr());
            pstm.setInt(5,dto.getNo());
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

    public int delete(int no) {

        // 1, 2.
        Connection con = getConnection();

        // 3.
        String sql = " DELETE FROM KHTEST " +
                     " WHERE NO = ? ";

        PreparedStatement pstm = null;
        int res = 0;

        try {

            pstm = con.prepareStatement(sql);
            pstm.setInt(1, no);

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
}
