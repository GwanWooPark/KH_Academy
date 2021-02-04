package com.test01;

import java.util.Arrays;

public class MTest02 {
    public static void main(String[] args) {

        // 1.
        int[][] a = new int[3][2];
        a[0][0] = 1;
        a[0][1] = 2;
        a[1][0] = 3;
        a[1][1] = 4;
        a[2][0] = 5;
        a[2][1] = 6;


        System.out.println(a[1][1]);


        // 2.
        int[][] b = new int[3][];

        b[0] = new int[3];
        b[1] = new int[5];
        b[2] = new int[2];

        // 3.
        int[][] c = new int[][]{
                {1, 2},
                {3, 4, 5, 6, 7},
                {8},
                {9, 10, 11}};

        // 4.
        int [][] d = new int[][] {{1, 2, 3, 4}, {5}, {6, 7}, {8, 9, 10}};
        System.out.println(d[3][1]);
        prn(d);

        String[][] s = {{"Hava", "a", "nice", "day"},
                        {"너무", "어려워"},
                        {"배열", "이차원 배열"}};

        modi(s);

        String [] qclass = {"가", "나", "다", "라", "마"};
        System.out.println(Arrays.toString(qclass));

        System.out.println(Arrays.deepToString(s));
    }

    public static void modi(String[][] arr) {

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j].equals("nice"))
                    arr[i][j] = "good";
                if (arr[i][j].equals("어려워"))
                    arr[i][j] = "쉬워";

                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

    }

    public static void prn(int[][] arr){
        // arr배열의 모든 요소를 출력하자.
        // 단, 각행의 끝마다 \n

        for (int i = 0; i < arr.length; i++){
            for (int j = 0; j < arr[i].length; j++){
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }

    }
}
