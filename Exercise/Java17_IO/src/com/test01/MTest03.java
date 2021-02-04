package com.test01;

import java.io.*;

public class MTest03 {

    public static void main(String[] args) {

        File fi = new File("a.txt");

        MyOutput(fi); // write
        MyInput(fi);// read

    }

    private static void MyInput(File fi) {
        FileInputStream fin = null;
        try {
            fin = new FileInputStream(fi);
            int res = 0;
            while ((res = fin.read()) != -1) {
                System.out.print((char) res);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                fin.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
    private static void MyOutput(File fi) {

        FileOutputStream fo = null;

        try {
            fo = new FileOutputStream(fi);
            for (int i = 65; i <= 90; i++) {
                fo.write(i);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fo.close(); //중요함 다른 애가 접속이 불가능하다.
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
