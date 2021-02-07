package com.score;

public class MTest {

    public static void main(String[] args) {

        Score lee = new Score();
        lee.setName("박관우");
        lee.setKor(100);
        lee.setEng(100);
        lee.setMath(100);

        Score hong = new Score("홍길동", 90, 90, 90);


        System.out.println(lee);
        System.out.println(hong.toString());
    }
}
