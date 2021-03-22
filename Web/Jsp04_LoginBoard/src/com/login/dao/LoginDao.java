package com.login.dao;

import com.login.dto.LoginDto;
import static com.login.db.JDBCTemplates.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
        return null;
    }

    // 2.
    public List<LoginDto> selectEnabledList() {
        return null;
    }

    // 3.
    public int updateRole(int myNo, String role) {

        return 0;
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
    public int insert() {
        return 0;
    }

    // 3.
    public LoginDto idCheck(String myId) {
        return null;
    }

    // 4.
    public LoginDto selectOne(int myNo) {
        return null;
    }

    // 5.
    public int update(LoginDto dto) {
        return 0;
    }

    // 6.
    public int delete(int myNo) {
        return 0;
    }
}
