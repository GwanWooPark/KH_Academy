package com.compare;

import java.util.Arrays;

public class MTest {

    public static void main(String[] args) {

        Score[] q_class = new Score[3];

        Score hong = new Score();
        hong.setName("홍길동");
        hong.setKor(100);
        hong.setEng(80);
        hong.setMath(70);
        q_class[0] = hong;

        Score park = new Score("박관우", 100, 100, 100);
        q_class[1] = park;

        q_class[2] = new Score("손흥민", 80, 80, 80);

        for (Score s : q_class) {
            System.out.println(s);
        }

        System.out.println("----------------------------------------------------------------------------------------------");
        Arrays.sort(q_class);
        for (Score s : q_class) {
            System.out.println(s);
        }
    }
}
