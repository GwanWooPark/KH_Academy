package com.test;

import com.qclass.Score;

public class MTest {

    public static void main(String[] args) {
        Score score = new Score();

        score.setName("박관우");
        score.setKor(100);
        score.setEng(100);
        score.setMath(100);

        System.out.println(score.getAvg());
        System.out.println(score.getGrade());

    }
}
