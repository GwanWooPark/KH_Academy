package com.member.db;

import java.sql.*;

// 중복되는 코드를 하나로 모음
public class JDBCTemplate {

    public static Connection getConnection() {

        // 1.
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // 2.
        String url = "";
        String user = "";
        String pass = "";
        Connection con = null;

        try {
            con = DriverManager.getConnection(url, user, pass);

            con.setAutoCommit(false);  // 자동으로 commit 하는 것을 해제

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return con;
    }

    public static void close(ResultSet rs) { // 한번에 만들어서 받아도 됨.
        try {
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void close(Statement stmt) {
        try {
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 오버로드
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

