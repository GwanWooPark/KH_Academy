package com.dept.dao;

import com.dept.dto.DeptDto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DeptDao {

    // 1.

    public List<DeptDto> selectList() {


        // 1. driver 연결
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            System.out.println("1. driver 연결");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // 2. 게정 연결
        String url = "jdbc:oracle:thin:@192.168.35.187:1521:xe";
        String id = "kh";
        String pass = "kh";
        Connection con = null;

        try {
            con = DriverManager.getConnection(url, id, pass);
            con.setAutoCommit(false);

            System.out.println("2. 계정 연결");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // 3. query 준비
        String sql = " SELECT DEPTNO, DNAME, LOC " +
                     " FROM DEPT " +
                     " ORDER BY DEPTNO ";

        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<DeptDto> list = new ArrayList<DeptDto>();

        try {
            // 4. query 실행 및 리턴
            assert con != null;
            pstm = con.prepareStatement(sql);
            System.out.println("3. query 준비 : " + sql);

            rs = pstm.executeQuery();
            System.out.println("4. query 실행 및 리턴");
            while (rs.next()) {
                DeptDto dto = new DeptDto();
                dto.setDeptNo(rs.getInt(1));
                dto.setdName(rs.getString(2));
                dto.setLoc(rs.getString(3));

                list.add(dto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

            // 5. db 종료
            try {
                rs.close();
                pstm.close();
                con.close();
                System.out.println("5. db 종료");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return list;
    }
}
