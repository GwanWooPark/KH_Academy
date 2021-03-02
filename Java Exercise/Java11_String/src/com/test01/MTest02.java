package com.test01;

import java.util.StringTokenizer;

public class MTest02 {
    public static void main(String[] args) {

        // substring
        String str01 = "The String class represents character strings.";
        System.out.println(str01.substring(11, 16));

        // split
        String str02 = "The,String,class";
        String[] splitArr = str02.split(",");

        for (String s : splitArr) System.out.println(s);

        // StringTokenizer
        String str03 = "The_String_class";

        StringTokenizer tokenizer = new StringTokenizer(str03, "_");

       /* while (tokenizer.hasMoreTokens()){
            System.out.println(tokenizer.nextToken());
        }*/

        System.out.println(tokenizer);
    }
}
