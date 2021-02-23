package com.test01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class MTest05 {


    // DELETE
    // DELETE FROM DEPT WHERE DEPTNO = ?
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("oracle.jdbc.driver.OracleDriver");

        String url = "jdbc:oracle:thin:@192.168.35.187:1521:xe";
        String user = "kh";
        String pass = "kh";

        Connection con = DriverManager.getConnection(url, user, pass);

        Scanner sc = new Scanner(System.in);

        System.out.print("삭제할 부서 번호 : ");
        int deptno = sc.nextInt();

        Statement stmt = con.createStatement();
        String sql = " DELETE FROM DEPT WHERE DEPTNO = " + deptno;
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
