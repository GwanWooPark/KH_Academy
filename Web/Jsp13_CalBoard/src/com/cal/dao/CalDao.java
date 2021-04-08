package com.cal.dao;
import com.cal.dto.CalDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.cal.db.JDBCTemplate.*;

public class CalDao {

    public List<CalDto> calendarList(String id, String yyyyMMdd) {

        Connection con = getConnection();

        String sql = " SELECT SEQ, ID, TITLE, CONTENT, MDATE, REGDATE "
                   + " FROM CALBOARD "
                   + " WHERE ID = ? "
                   + " AND SUBSTR(MDATE, 1, 8) = ? ";

        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<CalDto> list = new ArrayList<CalDto>();
        try {
            pstm = con.prepareStatement(sql);
            pstm.setString(1, id);
            pstm.setString(2, yyyyMMdd);

            rs = pstm.executeQuery();
            while (rs.next()) {
                CalDto dto = new CalDto(rs.getInt(1),
                                        rs.getString(2),
                                        rs.getString(3),
                                        rs.getString(4),
                                        rs.getString(5),
                                        rs.getDate(6));

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

    public int insert(CalDto dto) {

        Connection con = getConnection();

        String sql = " INSERT INTO CALBOARD "
                   + " VALUES (CALBOARDSEQ.NEXTVAL , ?, ?, ?, ?, SYSDATE) ";

        PreparedStatement pstm = null;
        int res = 0;

        try {

            pstm = con.prepareStatement(sql);
            pstm.setString(1, dto.getId());
            pstm.setString(2, dto.getTitle());
            pstm.setString(3, dto.getContent());
            pstm.setString(4, dto.getMdate());

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

    public List<CalDto> calendarViewList(String id, String yyyyMM) {

        Connection con = getConnection();

        String sql = " SELECT * "
                   + " FROM ( "
                   + " SELECT (ROW_NUMBER() over (PARTITION BY SUBSTR(MDATE, 1, 8) ORDER BY MDATE)) RN, SEQ, ID, TITLE, CONTENT, MDATE, REGDATE "
                   + " FROM CALBOARD "
                   + " WHERE ID = ? AND SUBSTR(MDATE, 1, 6) = ? "
                   + " ) "
                   + " WHERE RN BETWEEN 1 AND 3 ";

        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<CalDto> list = new ArrayList<CalDto>();

        try {
            pstm = con.prepareStatement(sql);
            pstm.setString(1, id);
            pstm.setString(2, yyyyMM);
            rs = pstm.executeQuery();
            while (rs.next()) {
                CalDto dto = new CalDto(rs.getInt(2),
                                        rs.getString(3),
                                        rs.getString(4),
                                        rs.getNString(5),
                                        rs.getString(6),
                                        rs.getDate(7));

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

    public int calendarViewCount(String id, String yyyyMMdd) {

        Connection con = getConnection();

        String sql = " SELECT COUNT(*) FROM CALBOARD WHERE ID = ? AND SUBSTR(MDATE, 1, 8) = ? ";

        PreparedStatement pstm = null;
        ResultSet rs = null;
        int count = 0;

        try {
            pstm = con.prepareStatement(sql);
            pstm.setString(1, id);
            pstm.setString(2, yyyyMMdd);
            rs = pstm.executeQuery();
            while (rs.next()) {
                count = rs.getInt(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(rs);
            close(pstm);
            close(con);
        }

        return count;
    }
}
