package com.test02;

import java.sql.*;
import java.util.Scanner;

public class Address {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        while (true) {

            System.out.println("1: 전체 출력");
            System.out.println("2: 선택 출력");
            System.out.println("3: 추가");
            System.out.println("4: 수정");
            System.out.println("5: 삭제");
            System.out.println("6: 종료");
            System.out.print("번호 선택 : ");

            int select = sc.nextInt();

            switch (select) {
                case 1:
                    System.out.println("전체 출력");
                    selectList();
                    break;
                case 2:
                    System.out.println("선택 출력");
                    selectOne();
                    break;
                case 3:
                    System.out.println("추가");
                    insert();
                    break;
                case 4:
                    System.out.println("수정");
                    update();
                    break;
                case 5:
                    System.out.println("삭제");
                    delete();
                    break;
                case 6:
                    System.out.println("프로그램 종료...");
                    System.exit(0);
            }
        }
    }

    public static void selectList(){
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String url = "jdbc:oracle:thin:@192.168.35.187:1521:xe";
        String user = "kh";
        String password = "kh";
        Connection con = null;
        try {
            con = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // 3.
        String sql = " SELECT NAME, PHONE, ADDR, EMAIL FROM ADDRESS ORDER BY NAME ";
        Statement stmt = null;
        ResultSet rs = null;

        try {
            stmt = con.createStatement();

            // 4.
            rs = stmt.executeQuery(sql);
            while(rs.next()) {
                System.out.println(rs.getString(1) + " \t"
                        + rs.getString(2) + " \t"
                        + rs.getString(3) + " \t"
                        + rs.getString(4));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 5.
            try {
                rs.close();
                stmt.close();
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }

    public static void selectOne() {

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String url = "jdbc:oracle:thin:@192.168.35.187:1521:xe";
        String user = "kh";
        String password = "kh";
        Connection con = null;
        try {
            con = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("이름 입력 : ");
        String name = sc.next();
        // 3.
        String sql = " SELECT NAME, PHONE, ADDR, EMAIL " +
                " FROM ADDRESS " +
                " WHERE NAME = ? ";
        PreparedStatement pstm = null;
        ResultSet rs = null;


        try {

            pstm = con.prepareStatement(sql);
            pstm.setString(1, name);

            // 4.
            rs = pstm.executeQuery();
            while(rs.next()) {
                System.out.println(rs.getString(1) + " \t"
                        + rs.getString(2) + " \t"
                        + rs.getString(3) + " \t"
                        + rs.getString(4));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 5.
            try {

                rs.close();
                pstm.close();
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }

    public static void insert() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        String url = "jdbc:oracle:thin:@192.168.35.187:1521:xe";
        String user = "kh";
        String pass = "kh";
        Connection con = null;

        try {
            con = DriverManager.getConnection(url, user, pass);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println("입력할 이름 : " );
        String name = sc.next();
        System.out.println("입력할 번호 : ");
        String phone = sc.next();
        System.out.println("입력할 주소 : ");
        String addr = sc.nextLine();
        System.out.println("입력할 이메일 : ");
        String email = sc.next();

        String sql = " INSERT INTO ADDRESS " +
                     " VALUES (?, ?, ?, ?) ";

        PreparedStatement pstm = null;

        try {
            pstm = con.prepareStatement(sql);
            pstm.setString(1, name);
            pstm.setString(2, phone);
            pstm.setString(3, addr);
            pstm.setString(4, email);

            int res = pstm.executeUpdate();
            if (res > 0) {
                System.out.println("추가 성공");
            } else {
                System.out.println("추가 실패");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                pstm.close();
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    public static void update() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        String url = "jdbc:oracle:thin:@192.168.35.187:1521:xe";
        String user = "kh";
        String pass = "kh";
        Connection con = null;

        try {
            con = DriverManager.getConnection(url, user, pass);
        } catch (SQLException e) {
            e.printStackTrace();
        }


        System.out.println("수정할 이름 : " );
        String name = sc.next();
        System.out.println("수정할 번호 : ");
        String phone = sc.next();
        System.out.println("수정할 주소 : ");
        String addr = sc.next();
        System.out.println("수정할 이메일 : ");
        String email = sc.next();

        String sql = " UPDATE ADDRESS " +
                " SET PHONE = ?, ADDR = ?, EMAIL = ? " +
                " WHERE NAME = ? ";

        PreparedStatement pstm = null;

        try {
            pstm = con.prepareStatement(sql);
            pstm.setString(1, phone);
            pstm.setString(2, addr);
            pstm.setString(3, email);
            pstm.setString(4, name);

            int res = pstm.executeUpdate(); // INSERT, UPDATE, DELETE
            if (res > 0) {
                System.out.println("수정 성공");
            } else {
                System.out.println("수 실패");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                pstm.close();
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void delete() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        String url = "jdbc:oracle:thin:@192.168.35.187:1521:xe";
        String user = "kh";
        String pass = "kh";
        Connection con = null;

        try {
            con = DriverManager.getConnection(url, user, pass);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println("입력할 이름 : " );
        String name = sc.next();
        System.out.println("입력할 번호 : ");
        String phone = sc.next();
        System.out.println("입력할 주소 : ");
        String addr = sc.nextLine();
        System.out.println("입력할 이메일 : ");
        String email = sc.next();

        String sql = " DELETE FROM ADDRESS " +
                " WHERE NAME = ? ";

        PreparedStatement pstm = null;

        try {
            pstm = con.prepareStatement(sql);

            int res = pstm.executeUpdate();
            if (res > 0) {
                System.out.println("삭제 성공");
            } else {
                System.out.println("삭제 실패");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                pstm.close();
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
