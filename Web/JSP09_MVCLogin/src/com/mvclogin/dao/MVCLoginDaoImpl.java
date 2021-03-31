package com.mvclogin.dao;

import com.mvclogin.dto.MVCLoginDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import static com.mvclogin.db.JDBCTemplate.*;

public class MVCLoginDaoImpl implements MVCLoginDao{

    @Override
    public List<MVCLoginDto> selectList() {

        Connection con = getConnection();

        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<MVCLoginDto> list = new ArrayList<MVCLoginDto>();

        try {
            pstm = con.prepareStatement(SELECT_LIST_SQL);
            rs = pstm.executeQuery();

            while (rs.next()) {
                MVCLoginDto dto = new MVCLoginDto();
                dto.setMyid(rs.getString(1));
                dto.setMypw(rs.getString(2));
                dto.setMyname(rs.getString(3));
                dto.setMyaddr(rs.getString(4));
                dto.setMyphone(rs.getString(5));
                dto.setMyemail(rs.getString(6));
                dto.setMyenabled(rs.getString(7));
                dto.setMyrole(rs.getString(8));

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
    public List<MVCLoginDto> selectEnabledList() {

        Connection con = getConnection();

        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<MVCLoginDto> list = new ArrayList<MVCLoginDto>();

        try {
            pstm = con.prepareStatement(SELECT_LIST_ENABLED_SQL);
            rs = pstm.executeQuery();

            while (rs.next()) {
                MVCLoginDto dto = new MVCLoginDto();
                dto.setMyid(rs.getString(1));
                dto.setMypw(rs.getString(2));
                dto.setMyname(rs.getString(3));
                dto.setMyaddr(rs.getString(4));
                dto.setMyphone(rs.getString(5));
                dto.setMyemail(rs.getString(6));
                dto.setMyenabled(rs.getString(7));
                dto.setMyrole(rs.getString(8));

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
    public int updateRole(int myNo, String role) {
        return 0;
    }

    @Override
    public MVCLoginDto login(String myId, String myPw) {

        Connection con = getConnection();

        PreparedStatement pstm = null;
        ResultSet rs = null;
        MVCLoginDto loginDto = null;
        try {
            pstm = con.prepareStatement(LOGIN_SQL);
            pstm.setString(1, myId);
            pstm.setString(2, myPw);
            rs = pstm.executeQuery();

            while (rs.next()) {
                loginDto = new MVCLoginDto(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(rs);
            close(pstm);
            close(con);
        }

        return loginDto;
    }

    @Override
    public int regist(MVCLoginDto dto) {
        return 0;
    }

    @Override
    public MVCLoginDto selectOne(String myId) {
        return null;
    }

    @Override
    public int updateMyRole(String myId) {
        return 0;
    }

    @Override
    public int signOut(String myId) {
        return 0;
    }
}
