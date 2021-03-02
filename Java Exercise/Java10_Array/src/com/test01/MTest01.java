package com.test01;

public class MTest01 {
    public static void main(String[] args) {
        // array 만드는 방법

        // 1.
        int [] a; // 선언
        a = new int[5];

        a[0] = 1;
        a[1] = 2;
        a[2] = 3;
        a[3] = 4;
        a[4] = 5;

        System.out.println(a[2]);
        System.out.println(a[1] + a[3]);

        // 2. 선언, 정의, 초기화
        int [] b = new int[] {5,4,3,2,1};

        System.out.println(b[1]);

        // 3. 선언, 초기화

        int [] c = {7, 8, 9, 1, 2};

       // System.out.println(c);
        prn(c);
        System.out.println();

        String[] s = new String[] {"Have", "a", "nice", "day"};
        modi(s);
    }
    public static void modi(String[] arr) {
        //nice를 "good"으로 바꾸고, 전체 출력
        for(int i = 0; i <arr.length; i++){
            if(arr[i].equals("nice")){
                arr[i] = "good";
            }
            System.out.printf("%s ", arr[i]);
        }
    }
    public static void prn (int[] arr) {

        for (int j : arr) {
            System.out.printf("%d ", j);
        }
    }
}
