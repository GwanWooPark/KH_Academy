package com.kh.db;

import java.sql.*;

public class JDBCTemplate {

    public static Connection getConnection() {

        // 1. ojdbc6.jar 파일에 있는 oracle.jdbc.driver 패키지안에  OracleDriver 클래스를 사용하겠다.
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // 2.

        String url = "jdbc:oracle:thin:@192.168.35.187:1521:xe";
        String id = "kh";
        String pw = "kh";
        Connection con = null;

        try {
            con = DriverManager.getConnection(url, id, pw);
            con.setAutoCommit(false);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }

    public static void close(Statement stmt) {
        try {
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void close(ResultSet rs) {
        try {
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void close(Connection con) {
        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void commit(Connection con) {
        try {
            con.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void rollback(Connection con) {
        try {
            con.rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
