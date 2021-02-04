package com.test03;

public class MySum {

    public static int sum(int i, int j) {
        return i + j;
    }

    // Overload
    public static double sum(double i, double j) {
        return i + j;
    }
    // Overload
    public static void sum(int i, int j, int k) {
        System.out.println(i + j + k);
    }
}
