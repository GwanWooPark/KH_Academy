package com.test01;

public class MTest02 {

    public static void main(String[] args) {
        //연산자를 이용하여 su의 각 자리수를 모두 더하여서 출력하자.
        int su = 5678;

        int sum = Simple(su);
        System.out.println(su + "의 각 자리수의 총 합은 " + sum + "입니다.");
        int sum1 = Use_while(su);
        System.out.println(su + "의 각 자리수의 총 합은 " + sum + "입니다.");
        int sum2 = Use_for(su);
        System.out.println(su + "의 각 자리수의 총 합은 " + sum + "입니다.");

    }

    public static int Simple(int su) {
        int a = (su / 1) % 10;
        int b = (su / 10) % 10;
        int c = (su / 100) % 10;
        int d = (su / 1000) % 10;

        return a+b+c+d;

    }

    public static int Use_while(int su) {

        String s = String.valueOf(su);
        int len = s.length();

        double sum = 0;
        double idx;

        while (true){
            sum += su % Math.pow(10, len);
            idx = su % Math.pow(10, len);
            su -= idx * Math.pow(10, len);
            len--;

            if(len == 0)
                break;
        }

        return (int)sum;

    }

    public static int Use_for(int su) {

        String s = String.valueOf(su);
        int len = s.length(); // 숫자의 길이를 구함

        double sum = 0; // 각 자리들의 합을 구하기 위한 변수
        double idx;

        for(int i = len; i>0; i--){
            sum += su % Math.pow(10, len);
            idx = su % Math.pow(10, len);
            su -= idx * Math.pow(10, len);
            len--;

        }

        return (int) sum;

    }

}
