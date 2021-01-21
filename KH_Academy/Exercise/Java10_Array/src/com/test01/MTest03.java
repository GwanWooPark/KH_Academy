package com.test01;

public class MTest03 {

    public static void main(String[] args) {

        char[] ch = new char[26];
        for (int i = 0; i < 26; i++) {
            ch[i] = (char)('a' + i);
        }


        /*
           1. 다음과 같이 출력하라.
           a b c d e f
           g h i j k l
           m n o p q r
           s t u v w x
           y z
         */

        prn(ch);

        // 2. 1번과 같은 형태인데, 거꾸로 출력.
        reverse(ch);

        // 3. 1번과 같은 형태인데, 대문자로 출력.
        upper(ch);
    }

    public static void prn(char[] arr) {

        for (int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
            if(i % 6 == 5)
                System.out.println();
        }
        System.out.println();
        System.out.println("---------------------");
    }

    public static void reverse(char[] arr) {
        for (int i = arr.length; i > 0; i--){
            System.out.print(arr[i-1] + " ");
            if(i % 6 == 3)
                System.out.println();
        }
        System.out.println();
        System.out.println("---------------------");
    }

    public static void upper(char[] arr) {
        for (int i = 0; i < arr.length; i++){
            System.out.print(Character.toUpperCase(arr[i]) + " ");
            if(i % 6 == 5)
                System.out.println();
        }

    }
}
