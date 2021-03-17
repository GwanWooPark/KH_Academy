package com.my.dao;
import com.my.dto.MyBoardDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.my.db.JDBCTemplate.*;

public class MyBoardDao {

    public List<MyBoardDto> selectList() {

        // 1, 2.
        Connection con = getConnection();

        // 3.
        String sql = " SELECT MYNO, MYNAME, MYTITLE, MYCONTENT, MYDATE " +
                     " FROM MYBOARD " +
                     " ORDER BY MYNO DESC ";

        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<MyBoardDto> list = new ArrayList<MyBoardDto>();

        try {
            pstm = con.prepareStatement(sql);
            rs = pstm.executeQuery();
            while (rs.next()) {
                MyBoardDto dto = new MyBoardDto();
                dto.setMyno(rs.getInt(1));
                dto.setMyname(rs.getString(2));
                dto.setMytitle(rs.getString(3));
                dto.setMycontent(rs.getString(4));
                dto.setMydate(rs.getDate(5));

                list.add(dto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(rs);
            close(pstm);
            close(con);
        }

        return list;
    }

    public MyBoardDto selectOne(int myno) {


        // 1, 2.
        Connection con = getConnection();

        // 3.
        String sql = " SELECT MYNO, MYNAME, MYTITLE, SYSDATE , MYCONTENT " +
                     " FROM MYBOARD " +
                     " WHERE MYNO = ? ";

        MyBoardDto dto = new MyBoardDto();
        PreparedStatement pstm = null;
        ResultSet rs = null;

        try {
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, myno);

            rs = pstm.executeQuery();

            while (rs.next()) {
                dto.setMyno(rs.getInt(1));
                dto.setMyname(rs.getString(2));
                dto.setMytitle(rs.getString(3));
                dto.setMydate(rs.getDate(4));
                dto.setMycontent(rs.getString(5));
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

    public int insert(MyBoardDto dto) {

        // 1, 2.
        Connection con = getConnection();

        // 3.
        String sql = " INSERT INTO MYBOARD " +
                     " VALUES (MYBOARDSEQ.NEXTVAL, ?, ?, ?, SYSDATE) ";

        PreparedStatement pstm = null;
        int res = 0;

        try {
            pstm = con.prepareStatement(sql);

            System.out.println("3. query 준비 : " + sql);

            pstm.setString(1, dto.getMyname());
            pstm.setString(2, dto.getMytitle());
            pstm.setString(3, dto.getMycontent());
            System.out.println("4. query 실행 및 리턴");

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
            System.out.println("5. db 종료");
        }
        return res;
    }

    public int update(MyBoardDto dto) {

        // 1, 2.
        Connection con = getConnection();

        // 3.
        String sql = " UPDATE MYBOARD " +
                     " SET MYTITLE = ?, MYCONTENT = ?, MYDATE = SYSDATE " +
                     " WHERE MYNO = ? ";

        PreparedStatement pstm = null;
        int res = 0;

        try {
            pstm = con.prepareStatement(sql);
            System.out.println("3. query 준비 : " + sql);

            pstm.setString(2, dto.getMytitle());
            pstm.setString(3, dto.getMycontent());
            pstm.setInt(4, dto.getMyno());

            System.out.println(dto.getMyno());
            System.out.println("4. query 실행 및 리턴");
            res = pstm.executeUpdate();
            if (res > 0) {
                commit(con);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(pstm);
            close(con);
            System.out.println("5. db 종료");
        }

        return res;
    }

    public int delete(int myno) {

        // 1, 2.
        Connection con = getConnection();

        // 3.

        String sql = " DELETE " +
                     " FROM MYBOARD " +
                     " WHERE MYNO = ? ";

        PreparedStatement pstm = null;
        int res = 0;

        try {

            pstm = con.prepareStatement(sql);
            pstm.setInt(1, myno);

            res = pstm.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(pstm);
            close(con);
        }

        return res;
    }
}
