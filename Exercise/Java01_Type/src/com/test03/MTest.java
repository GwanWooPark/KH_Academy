package com.test03;

public class MTest {
    public static void main(String[] args) {
        /*
        System.out.print()
        -> console에 출력.

        System.out.println()
        -> console에 출력 + 새로운 줄.

        System.out.printf()
        -> print'f' f : formatter (자리 or 형식 지정)
        -> java.util.formatter 확인!

         */

        int i = 100;
        System.out.print("1. i : " + i + "\n");
        System.out.println("2. i : " + i);
        System.out.printf("3. i : %5d\n" , i );
        System.out.println("\t끝");

        //escape character : \n  \t \\

        // "시험 점수 결과는 su점이고, 학점은 'grade' 가 나왔다. \n " 나의 오늘 감정지수는 d%이다.
        int su = 100;       //10칸
        char grade = 'A';   //5칸
        double d = 90.56d;   //5칸.소수점 첫째짜리까지만
        //System.out.printf 하나만 사용하여

        System.out.printf("시험 점수결과는 %10d 점이고, 학점은 '%5c' 가 나왔다.\n 나의 오늘 감정지수는 %.1f이다.", su, grade, d);
    }
}
