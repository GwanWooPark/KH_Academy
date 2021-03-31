package com.mvclogin.dao;

import com.mvclogin.dto.MVCBoardDto;
import com.mvclogin.dto.MVCLoginDto;
import static com.mvclogin.db.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MVCBoardDaoImpl implements MVCBoardDao{

    @Override
    public List<MVCBoardDto> selectList() {

        Connection con = getConnection();

        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<MVCBoardDto> list = new ArrayList<MVCBoardDto>();

        try {
            pstm = con.prepareStatement(SELECT_LIST);
            rs = pstm.executeQuery();
            while (rs.next()) {
                MVCBoardDto dto = new MVCBoardDto();
                dto.setNum(rs.getInt(1));
                dto.setWriter(rs.getString(2));
                dto.setTitle(rs.getString(3));
                dto.setContent(rs.getString(4));
                dto.setDate(rs.getDate(5));

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
    public MVCLoginDto selectOne(int num) {
        return null;
    }

    @Override
    public int insert(MVCBoardDto dto) {

        Connection con = getConnection();

        PreparedStatement pstm = null;
        int res = 0;

        try {

            pstm = con.prepareStatement(INSERT_BOARD);
            pstm.setString(1, dto.getWriter());
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
    public int update(MVCBoardDto dto) {
        return 0;
    }

    @Override
    public int delete(String writer) {
        return 0;
    }
}
