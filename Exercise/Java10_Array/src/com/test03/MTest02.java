package com.test03;

public class MTest02 {

    public static void main(String[] args) {
        /*
           1 4 7
           2 5 8
           3 6 9

           모양의 이차원 배열을 만들어서 출력.
         */

        int[][] arr = new int[3][3];

        for (int i = 0; i < arr.length; i++){
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = 3*j + i+1;
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
