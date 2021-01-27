package com.test01;

public class MTest {

    public static void main(String[] args) {
        AA a = new AA();
        // 부모 타입으로 자식 객체 대입

        Super s = a; // 묵시적 형 변환.

        AA abc = (AA)s;
        System.out.println(abc);


        // 부모 타입이 큰 타입, 자식 타입이 작은 타입
        //BB b = (BB) s; // 명시적 형 변환.
        //System.out.println(b);

    }
}
