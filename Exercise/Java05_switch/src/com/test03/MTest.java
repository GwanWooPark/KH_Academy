package com.test03;

public class MTest {
    /*
       1. 같은 패키지에 Score클래스 만들기.
       2. kor, eng, math 값을 받아서, 세 값의 평균을 리턴하는 getAvg 메소드를 만들기, 같은 패키지에서만 접근 가능하고, staic영역에 저장.

       3. Score class에서, 평균 값을 받아서 등급을 리턴하는 getGrade 메소드 만들기
          평균 > 90(A), 80 ~ 89.9(B), 70 ~ 79.9(C), 60 ~ 69.9(D), 그 외는 F
          어디서나 접근 가능하고, static영역에 저장됨.

       4. MTest class에서 Score 클래스의 두 메소드를 호출해서 리턴받은 값을 출력.
          출력 예) 홍길동님의 평균은 98.99이고, 등급은 "A"입니다.
     */

    public static void main(String[] args) {

        String name = "박관우";
        int kor = 100;
        int eng = 100;
        int math = 97;

        double avg = Score.getAvg(kor, eng, math);
        char grade = Score.getGrade(avg);

        System.out.printf("%s님의 평균은 %.2f이고, 등급은 \"%c\"입니다.", name, avg, grade);
    }
}
