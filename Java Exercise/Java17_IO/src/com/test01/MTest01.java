package com.test01;

import java.io.File;
import java.io.IOException;

public class MTest01 {

    public static void main(String[] args) {

        // 해당경로에 fi 생성
        File fi = new File("c:/TEST_IO");

        //File fi = new File("맥은 잘 알아서");

        if (fi.exists()) {
            System.out.println("exist");
        } else {
            System.out.println("New!");
            fi.mkdirs();
        }

        //fi 밑에 AA생성
        File aa = new File(fi, "AA");
        aa.mkdir();


        // fi 밑에 BB생성
        File bb = new File("c:/TEST_IO", "BB");
        bb.mkdir();

        // AA밑에 a.txt생성
        File a = new File(aa, "a.txt");

        // compile시 처리해야하는 예외 = checked exception
        try {
            a.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //Unhandled exception
    }

}
