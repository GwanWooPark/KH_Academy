package com.test03;

public class MTest03 {
    public static void main(String[] args) {

        /*
            1  2  3  4  5
           10  9  8  7  6
           11 12 13 14 15
           20 19 18 17 16
           21 22 23 24 25

           2차원 배열 출력
         */

        int[][] arr = new int[5][5];
        int count = 1;



        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if(i == 1){
                    arr[i][j] = 10 - j;
                    count++;
                }
                else if(i == 3) {
                    arr[i][j] = 20 - j;
                    count++;
                }
                else
                    arr[i][j] = count++;

                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
