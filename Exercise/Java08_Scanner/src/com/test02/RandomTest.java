package com.test02;

import jdk.swing.interop.SwingInterOpUtils;

import java.util.Random;

public class RandomTest {
    public static void main(String[] args) {
        //mathClass();
        randomClass();
    }

    public static void randomClass() {
        Random rd = new Random();
        System.out.println(rd.nextInt(100));
    }

    public static void mathClass() {
        double d_ran = Math.random();
        System.out.printf("%.2f", d_ran);
        System.out.println();

        //min ~ max까지 (int)(Math.random()*(max - min + 1)) + min;

        int min = 100;
        int max = 110;

        int i_ran = (int)(Math.random() * (max - min + 1)) + min;
        System.out.print(i_ran);
    }
}
