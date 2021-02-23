package com.test01;

import java.sql.*;
import java.util.Scanner;

public class MTest03 {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        // 1. driver 연결
        Class.forName("oracle.jdbc.driver.OracleDriver");

        // 2. 계정 연결
        String url = "jdbc:oracle:thin:@192.168.35.187:1521:xe";
        String user = "kh";
        String pass = "kh";

        Connection conn = DriverManager.getConnection(url, user, pass);


        // 3. query 준비
        Scanner sc = new Scanner(System.in);
        System.out.println("부서번호 : ");
        int deptno = sc.nextInt();
        System.out.println("부서 이름 : ");
        String dname = sc.next();
        System.out.println("부서 위치");
        String loc = sc.next();

        String sql = " INSERT INTO DEPT(DEPTNO, DNAME, LOC)" +
                "VALUES( " + deptno + " , '" + dname + "' , '" + loc + "') ";

        Statement stmt = conn.createStatement();
        // 4. query 실행 및 리턴

        // 4-1. SELECT일 땐, 결과 테이블을 받아줄 ResultSet 사용.
        // ResultSet rs = stmt.executeQuery(sql); 결과 테스트를 받음

        // 4-2. INSERT, UPDATE, DELETE일 땐, 적용된 갯수를 받는다.
        int res = stmt.executeUpdate(sql);
        if (res > 0) {
            System.out.println("insert 성공");
        } else {
            System.out.println("insert 실패");
        }

        // 5. db 종료
        stmt.close();
        conn.close();

    }
}
