package com.mvc.dao;

import com.mvc.dto.MVCDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import static com.mvc.db.JDBCTemplates.*;

public class MVCDaoImpl implements MVCDao{

    @Override
    public List<MVCDto> selectList() {

        Connection con = getConnection();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<MVCDto> list = new ArrayList<MVCDto>();

        try {
            pstm = con.prepareStatement(SELECT_LIST_SQL);
            rs = pstm.executeQuery();
            while (rs.next()) {
                MVCDto dto = new MVCDto(rs.getInt("SEQ"),
                        rs.getString("WRITER"),
                        rs.getString("TITLE"),
                        rs.getString("CONTENT"),
                        rs.getDate("REGDATE"));

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

    @Override
    public MVCDto selectOne(int seq) {

        Connection con = getConnection();

        PreparedStatement pstm = null;
        ResultSet rs = null;
        MVCDto dto = new MVCDto();

        try {
            pstm = con.prepareStatement(SELECT_ONE_SQL);
            rs = pstm.executeQuery();


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(rs);
            close(pstm);
            close(con);
        }
        return dto;
    }

    @Override
    public int insert(MVCDto dto) {

        Connection con = getConnection();

        PreparedStatement pstm = null;
        int res = 0;

        try {
            pstm = con.prepareStatement(INSERT_SQL);
            pstm.setString(1, dto.getWiter());
            pstm.setString(2, dto.getTitle());
            pstm.setString(3, dto.getContent());
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
    public int update(MVCDto dto) {

        Connection con = getConnection();

        PreparedStatement pstm = null;
        int res = 0;

        try {
            pstm = con.prepareStatement(UPDATE_SQL);

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
    public int delete(int seq) {

        Connection con = getConnection();

        PreparedStatement pstm = null;
        int res = 0;

        try {
            pstm = con.prepareStatement(DELETE_SQL);

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
