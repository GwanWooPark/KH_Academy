package com.b;

import com.a.AAA;

public class BBB extends AAA {

    private int b;

    // 기본 생성자
    public BBB() {
        super();
        // super(); -> 해당 명령어가 없어도 자동으로 부모 생성자 호출
        System.out.println("BBB()");
    }
    // 파라미터 한 개짜리 생성자
    public BBB(int b) {
        // 부모의 생성자 -> AAA(int abc);
        super(b); // 부모 생성자 호출
        this.b = b;
        System.out.println("BBB(int b)");
    }

    // 파라미터 두 개짜리 생성자
    public BBB(int abc, int b) {
        super(abc);
        this.b = b;
        System.out.println("BBB(int abc, int b)");
    }

    // getter & setter
    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public int getSum() {
        // super : 부모 객체
        // this : 나 객체
        // super() : 부모 생성자
        // this() : 나 생성자
        int sum = super.getAbc() + this.getB();

        return sum;
    }

    // 재정의
    @Override
    public void prn() {
        System.out.println("BB의 prn()");
    }
}
