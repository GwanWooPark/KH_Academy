package com.test01;

import java.io.File;

public class MTest02 {

    public static void main(String[] args) {

        /*
          c:\ -> window
          /User/이름/ -> linux(Mac OS)
         */
        File fi = new File("c:\\");

        //prnFolder01(fi);
        prnFolder02(fi);
    }

    public static void prnFolder01(File fi) {
        for (String list : fi.list()) {
            System.out.println(list);
        }
    }
    public static void prnFolder02(File fi) {
        /*
           파일과 폴더를 구분해서 출력
           ex) file : DumpStack.log.tmp
               file : hiberfil.sys
               dir : Interl


               file의 총 갯수 : n개
               dir의 총 갯수 : m개
        */

        int file_c = 0;
        int dir_c = 0;
/*
        File[] list = fi.listFiles();


        for (int i = 0; i < fi.list().length; i++) {

            if (list[i].isDirectory()) {
                System.out.println("dir : " + list[i]);
                dir_c += 1;
            } else {
                System.out.println("file : " + list[i]);
                file_c += 1;
            }
        }*/

        for (File file : fi.listFiles()
        ) {
            if (file.isDirectory()) {
                System.out.println("dir : " + file);
                dir_c += 1;
            } else if (file.isFile()) {
                System.out.println("file : " + file);
                file_c += 1;
            }
        }
        System.out.println("dir 의 총 갯수 : " + dir_c);
        System.out.println("file의 총 갯수 : " + file_c);
    }
}
