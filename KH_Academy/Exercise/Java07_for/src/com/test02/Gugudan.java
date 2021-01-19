package com.test02;

public class Gugudan {
    public static void main(String[] args) {
        gugu();
    }

    public static void gugu() {
        // 2단부터 9단까지 전체 출력

        for(int i = 2; i < 10; i++) {
            for (int j = 1; j < 10; j++) {
                System.out.printf("%d * %d = %d\t", i, j, i*j);
            }
            System.out.println();
        }
    }
}
