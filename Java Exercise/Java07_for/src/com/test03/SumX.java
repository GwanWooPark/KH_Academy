package com.test03;

public class SumX {
    /*
        1  2  3  4  5
        6  7  8  9  10
        11 12 13 14 15
        16 17 18 19 20
        21 22 23 24 25

        x의 총합
        117

     */
    public static void main(String[] args) {
        Sum();
    }

    public static void Sum() {

        int sum = 0;


        for (int i = 1; i < 26; i++) {
            System.out.print(i + "\t");
            if (i % 5 == 0)
                System.out.println();

            if(i%6 == 1 || i % 4 == 1)
                sum+=i;


        }

        System.out.printf("합은 : %d " ,sum);

    }
}
