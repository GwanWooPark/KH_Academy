package com.test01;

import java.sql.*;
import java.util.Scanner;

public class MTest02 {

    // SELECT ONE
    public static void main(String[] args) throws  ClassNotFoundException, SQLException {

        // 1. driver 연결
        Class.forName("oracle.jdbc.driver.OracleDriver");

        // 2. 계정 연결
        String url = "jdbc:oracle:thin:@192.168.35.187:1521:xe";
        String id = "kh";
        String pass = "kh";
        Connection conn = DriverManager.getConnection(url, id, pass);

        // 3. query 준비
        Scanner sc = new Scanner(System.in);
        System.out.println("번호 입력 : ");
        int empno = sc.nextInt();
        String sql = " SELECT EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO "
                   + " FROM EMP "
                   + " WHERE EMPNO = " + empno;

        Statement stmt = conn.createStatement();

        // 4. query 실행 및 리턴
        ResultSet rs = stmt.executeQuery(sql);

        while (rs.next()) {
            System.out.printf("%d %6s %6s %6d  %8s %6d %4d %3d \n",
                    rs.getInt("EMPNO"),
                    rs.getString("ENAME"),
                    rs.getString("JOB"),
                    rs.getInt("MGR"),
                    rs.getDate("HIREDATE"),
                    rs.getInt("SAL"),
                    rs.getInt("COMM"),
                    rs.getInt("DEPTNO"));
        }

        // 5. db 종료
        rs.close();
        stmt.close();
        conn.close();
    }
}
