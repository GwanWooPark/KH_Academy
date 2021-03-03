package com.test01;

public class MTest01 {

    // method :  명령문들의 집합
    // main method : 프로그램의 주 진입점

    public static void main(String[] args) {
        MTest01.publicMethod();
        MTest01.protectedMethod();
        defaultMethod();
        privateMethod();
    }

    public static void publicMethod() {
        System.out.println("public method");
        System.out.println("어디에서나 접근, 참조 가능(+)\n");

    }

    protected static void protectedMethod() {
        System.out.println("protected method");
        System.out.println("상속일 경우엔 상속된 곳에서");
        System.out.println("상속이 아닐 경우엔 같은 패키지 내에서 접근, 참조 가능(#)\n");
    }

    // dafault 라는 keyword를 작성하지 않는다!!
    static void defaultMethod() {
        System.out.println("default method");
        System.out.println("같은 패키지 내에서 접근, 참조 가능(~)\n");
    }

    private static void privateMethod() {
        System.out.println("private method");
        System.out.println("같은 클래스 내에서만 접근 가능, 참조가능(-)");
    }

    public void nonStaticMethod() {
        System.out.println("non static method");
        System.out.println("class 변수 = new class()");
        System.out.println("변수.method()");
        System.out.println("형태로 호출할 수 있다.");
    }
}