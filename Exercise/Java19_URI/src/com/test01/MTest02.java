package com.test01;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
// java.net - network와 관련있는 패키지
public class MTest02 {

    // 이미지 읽어서 저장
    public static void main(String[] args) throws IOException {

        URL url = new URL("https://cdn1.iconfinder.com/data/icons/system-black-circles/512/java-512.png");
        URLConnection urlConnection = url.openConnection();
        urlConnection.connect();

        // InputStream - read
        // OuputStream - write
        DataInputStream din = new DataInputStream(urlConnection.getInputStream());

        FileOutputStream fout = new FileOutputStream("a.png");

        byte[] b = new byte[1];

        while (din.read(b, 0, 1) != -1) {
            fout.write(b, 0, 1);
        }
        fout.close();
        din.close();
    }
}
