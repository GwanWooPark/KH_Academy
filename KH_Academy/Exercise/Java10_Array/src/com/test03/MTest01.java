package com.test03;

import java.util.Random;

public class MTest01 {

    public static void main(String[] args) {

        /*
          1. 5칸짜리 int type의 값을 받을 수 있는 1차원 배열을 생성
          2. 반복문을 사용하여, 배열의 0번지부터 3번지까지 5~9사이의 랜덤한 숫자를 각각 대입.
          3. 배열의 0 ~ 3번지에 저장된 값들을 모두 곱해서, 4번인덱스에 저장.
          4. 배열 출력
          5. 배열 안에 있는 모든 값(0 ~ 4번지)를 더해서 출력.
        */

        int[] arr = new int[5];
        double min = 5;
        double max = 9;
        int temp = 1;

        for (int i = 0; i < 4; i++) {
            arr[i] = (int)((Math.random() * (max-min)) + min);
            temp *= arr[i];
        }
        arr[4] = temp;
        temp = 0;

        for (int j : arr) temp += j;

        System.out.println(temp);

    }
}
