package com.test03;

public class MyCalc {

    // method :  접근제한자 메모리영역 리턴타입 메소드명(parameter) { // 명령문들 }
    public static void sum(int i, int j) {
        int result = i + j;
        System.out.printf("%d + %d = %d", i, j, result);

    }

    public static int sub(int i, int j) {
        int result = i - j;

        return result;
    }

    public static void mul(double i, double j) {
        double result = i * j;
        System.out.printf("%d * %d = %d", i, j, result);
    }

    public static void div(int i, int j) {
        int div01 = i / j;
        int div02 = i % j;
        System.out.printf("%d / %d = %d", i, j, div01);
        System.out.printf("%d % %d = %d", i, j, div02);
    }
}
