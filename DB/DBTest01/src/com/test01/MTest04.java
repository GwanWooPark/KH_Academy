package com.test01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class MTest04 {


    // UPDATE
    public static void main(String[] args) throws ClassNotFoundException, SQLException {


        Class.forName("oracle.jdbc.driver.OracleDriver");

        String url = "jdbc:oracle:thin:@192.168.35.187:1521:xe";
        String user = "kh";
        String pass = "kh";

        Connection con = DriverManager.getConnection(url, user, pass);



        Scanner sc = new Scanner(System.in);

        System.out.println("부서 이름 : ");
        String dname = sc.next();
        System.out.println("부서 위치");
        String loc = sc.next();


        Statement stmt = con.createStatement();
        String sql = " UPDATE DEPT " +
                     " SET DNAME = '" + dname + "', " +
                     " LOC = '" + loc + "' " +
                     " WHERE DEPTNO = 50 ";

        int res = stmt.executeUpdate(sql);

        if (res > 0) {
            System.out.println("변경 성공");
        } else {
            System.out.println("변경 실패");
        }

        stmt.close();
        con.close();
    }
}
