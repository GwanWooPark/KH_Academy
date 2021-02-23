package com.member.dao;

import com.member.dto.MemberDto;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
           " FROM MEMEBER " +
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
}