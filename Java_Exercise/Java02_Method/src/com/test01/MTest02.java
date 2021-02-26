package com.test01;

public class MTest02 {
    public static void main(String[] args) {

        MTest01.defaultMethod();
        MTest01.protectedMethod();
        MTest01.publicMethod();


        System.out.println("-------------------");

        MTest01 nonStatic = new MTest01(); //참조 타입
        nonStatic.nonStaticMethod();

    }
}
