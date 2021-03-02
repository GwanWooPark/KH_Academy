package com.test02;

import java.io.*;

public class MTest {

    public static void main(String[] args) throws IOException {

        String fileName = "a.jpeg";

/*
        FileInputStream fi = new FileInputStream(fileName);
        BufferedInputStream bi = new BufferedInputStream(fi);
*/

        BufferedInputStream bi = new BufferedInputStream(new FileInputStream(fileName));

        FileOutputStream fo = new FileOutputStream(new File("b.jpeg"));

        int a = 0;
        while ((a = bi.read()) != -1) {
            fo.write(a);
        }

        // 나중에 만든 객체부터 먼저 닫자.
        fo.close();
        bi.close();

    }
}
