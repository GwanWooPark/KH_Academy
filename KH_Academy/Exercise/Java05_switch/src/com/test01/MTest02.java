package com.test01;

public class MTest02 {

    public static void main(String[] args) {
        // 식/값 -> 정수형, 문자형, 문자열(java 1.7 이후부터 가능)

        String s = "한국";

        switch (s) {
            case "한국":
                System.out.println("Korea");
                break;
            case "중국":
                System.out.println("China");
                break;
            case "일본":
                System.out.println("Japan");
                break;
        }
    }


}
