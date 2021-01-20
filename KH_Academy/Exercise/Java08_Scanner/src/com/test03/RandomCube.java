package com.test03;

import java.util.Random;

public class RandomCube {
    public static void main(String[] args) {
        prn();
    }

    /*
       1)
       1~9 사이의 랜덤한 숫자를 가지고
       5 by 5 형태의 숫자 큐브를 출력

       1 2 4 5 2
       2 5 6 7 8
       2 5 7 8 9
       2 4 5 6 7

       2) 만들어진 상자에서 x의 합을 출력하고, 전체 숫자의 평균 출력.

     */
    public static void prn() {

        Random rd = new Random();
        int sumX= 0;
        int sumA = 0;
        int num = 0;
        int cnt = 0;


        for (int i = 0; i < 5; i++)
        {
            for (int j = 0; j < 5; j++) {
                num = rd.nextInt(9) + 1;
                System.out.printf("%d ", num);
                sumA += num;
                cnt++;

                if((i == j) || j + i == 4)
                    sumX += num;
            }

            System.out.println();
        }

        double avg = (double)sumA / cnt;

        System.out.println(avg);
        System.out.println(sumX);

        //(0,4) , (1,3), (2,2), (3,1), (4,0)
    }
}
