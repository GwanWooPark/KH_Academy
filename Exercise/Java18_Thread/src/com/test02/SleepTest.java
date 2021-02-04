package com.test02;

public class SleepTest {

    public static void main(String[] args) {

        while (true) {

            for (int i = 0; i <= 10; i++) {

                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.printf("%c", '*');
            }
            System.out.println();
        }
    }
}
