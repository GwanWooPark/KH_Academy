package com.login.dao;

import com.login.dto.LoginDto;
import static com.login.db.JDBCTemplates.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LoginDao {

    /*
       관리자 기능
       1. 회원 전체 정보 (모든 회원)
       2. 가입된 회원의 전체 정보 (MYENABLED = 'Y'인 회원)
       3. 회원 등급 조정
     */

    // 1.
    public List<LoginDto> selectAllList() {

        Connection con = getConnection();

        String sql = " SELECT MYNO, MYID, MYPW, MYNAME, MYADDR, MYPHONE, MYEMAIL, MYENABLED, MYROLE " +
                     " FROM MYMEMBER " +
                     " ORDER BY MYNO ";

        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<LoginDto> list = new ArrayList<LoginDto>();

        try {
            pstm = con.prepareStatement(sql);
            rs = pstm.executeQuery();

            while (rs.next()) {
                LoginDto dto = new LoginDto();
                dto.setMyNo(rs.getInt(1));
                dto.setMyId(rs.getString(2));
                dto.setMyPw(rs.getString(3));
                dto.setMyName(rs.getString(4));
                dto.setMyAddr(rs.getString(5));
                dto.setMyPhone(rs.getString(6));
                dto.setMyEmail(rs.getString(7));
                dto.setMyEnabled(rs.getString(8));
                dto.setMyRole(rs.getString(9));

                list.add(dto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(rs, pstm, con);
        }
        return list;
    }

    // 2.
    public List<LoginDto> selectEnabledList() {

        Connection con = getConnection();

        String sql = " SELECT MYNO, MYID, MYPW, MYNAME, MYADDR, MYPHONE, MYEMAIL, MYENABLED, MYROLE " +
                     " FROM MYMEMBER " +
                     " WHERE MYENABLED = 'Y' " +
                     " ORDER BY MYNO ";

        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<LoginDto> list = new ArrayList<LoginDto>();

        try {
            pstm = con.prepareStatement(sql);
            rs = pstm.executeQuery();

            while (rs.next()) {
                LoginDto dto = new LoginDto();
                dto.setMyNo(rs.getInt(1));
                dto.setMyId(rs.getString(2));
                dto.setMyPw(rs.getString(3));
                dto.setMyName(rs.getString(4));
                dto.setMyAddr(rs.getString(5));
                dto.setMyPhone(rs.getString(6));
                dto.setMyEmail(rs.getString(7));
                dto.setMyEnabled(rs.getString(8));
                dto.setMyRole(rs.getString(9));

                list.add(dto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(rs, pstm, con);
        }
        return list;
    }

    // 3.
    public int updateRole(int myNo, String role) {

        Connection con = getConnection();

        String sql = " UPDATE MYMEMBER " +
                     " SET MYROLE = ? " +
                     " WHERE MYNO = ? ";

        PreparedStatement pstm = null;
        int res = 0;

        try {
            pstm = con.prepareStatement(sql);
            pstm.setString(1, role);
            pstm.setInt(2, myNo);
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

    /*
      사용자 기능
      1. 로그인
      2. 회원가입
      3. 내 정보 조회
      4. 내 정보 수정
      5. 탈퇴
      6.
     */

    // 1.
    public LoginDto login(String myId, String myPw) {

        Connection con = getConnection();

        String sql = " SELECT MYNO, MYID, MYPW, MYNAME, MYADDR, MYPHONE, MYEMAIL, MYENABLED, MYROLE " +
                     " FROM MYMEMBER " +
                     " WHERE MYID = ? " +
                     " AND MYPW = ? ";

        PreparedStatement pstm = null;
        ResultSet rs = null;
        LoginDto dto = null;

        try {
            pstm = con.prepareStatement(sql);
            pstm.setString(1, myId);
            pstm.setString(2, myPw);

            rs = pstm.executeQuery();

            while (rs.next()) {
               dto = new LoginDto(rs.getInt(1),
                       rs.getString(2),
                       rs.getString(3),
                       rs.getString(4),
                       rs.getString(5),
                       rs.getString(6),
                       rs.getString(7),
                       rs.getString(8),
                       rs.getString(9));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(rs, pstm, con);
        }

        return dto;
    }

    // 2.
    public int insert(LoginDto dto) {

        Connection con = getConnection();

        String sql = " INSERT INTO MYMEMBER " +
                     " VALUES (MEMBERSEQ.NEXTVAL, ?, ?, ?, ?, ?, ?, 'Y', 'USER') ";

        PreparedStatement pstm = null;
        int res = 0;

        try {
            pstm = con.prepareStatement(sql);
            pstm.setString(1, dto.getMyId());
            pstm.setString(2, dto.getMyPw());
            pstm.setString(3, dto.getMyName());
            pstm.setString(4,dto.getMyAddr());
            pstm.setString(5, dto.getMyPhone());
            pstm.setString(6, dto.getMyEmail());

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

    // 3.
    public LoginDto idCheck(String myId) {

        Connection con = getConnection();

        String sql = " SELECT MYID " +
                     " FROM MYMEMBER " +
                     " WHERE MYID = ? ";

        PreparedStatement pstm = null;
        ResultSet rs = null;
        LoginDto dto = null;

        try {
            pstm = con.prepareStatement(sql);
            pstm.setString(1, myId);
            rs = pstm.executeQuery();

            while (rs.next()) {
                dto = new LoginDto();
                dto.setMyId(rs.getString(1));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(rs, pstm, con);
        }

        return dto;
    }

    // 4.
    public LoginDto selectOne(int myNo) {

        Connection con = getConnection();

        String sql = " SELECT MYNO, MYID, MYNAME, MYADDR, MYPHONE, MYEMAIL, MYENABLED, MYROLE " +
                     " FROM MYMEMBER " +
                     " WHERE MYNO = ? ";

        PreparedStatement pstm = null;
        ResultSet rs = null;
        LoginDto dto = null;

        try {
            pstm = con.prepareStatement(sql);
            pstm.setInt(1,myNo);
            rs = pstm.executeQuery();

            while (rs.next()) {
                dto = new LoginDto();
                dto.setMyNo(rs.getInt(1));
                dto.setMyId(rs.getString(2));
                dto.setMyName(rs.getString(3));
                dto.setMyAddr(rs.getString(4));
                dto.setMyPhone(rs.getString(5));
                dto.setMyEmail(rs.getString(6));
                dto.setMyEnabled(rs.getString(7));
                dto.setMyRole(rs.getString(8));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(pstm);
            close(con);
        }

        return dto;
    }

    // 5.
    public int update(LoginDto dto) {

        Connection con = getConnection();


        String sql = " UPDATE MYMEMBER " +
                     " SET MYPW = ?, MYADDR = ?, MYPHONE =?, MYEMAIL = ? " +
                     " WHERE MYNO = ? ";


        PreparedStatement pstm = null;
        int res = 0;

        try {
            pstm = con.prepareStatement(sql);
            pstm.setString(1, dto.getMyPw());
            pstm.setString(2,dto.getMyAddr());
            pstm.setString(3,dto.getMyPhone());
            pstm.setString(4,dto.getMyEmail());
            pstm.setInt(5, dto.getMyNo());

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

    // 6.
    public int delete(int myNo) {

        Connection con = getConnection();

        String sql = " UPDATE MYMEMBER " +
                     " SET MYENABLED = 'N' " +
                     " WHERE MYNO = ? ";

        PreparedStatement pstm = null;
        int res = 0;

        try {
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, myNo);
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
