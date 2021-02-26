package com.test02;

public class MTest {
    /*
    1. com.test02 package에 Season 이라는 클래스를 만들자.
    2. Season클래스는 어디에서나 접근가능하고, int형 "월" 값을 받으면 String으로 리턴하는 prn 메소드 (non-static)
    3. Season 클래스의 prn method에서는 입력받은 월 값이 12, 1, 2면 "겨울" , 3, 4, 5면 "봄", 6, 7, 8이면 "여름", 9, 10, 11 이면 "가을" 리턴
    switch이용

    4. MTest class 의  main method에서 Season class의 prn method를 호출하는데, args를 1월을 넣어줘서 리턴받은 값을 출력하자.
     */

    public static void main(String[] args) {
        Season season = new Season();
        System.out.println(season.prn(1));

    }
}
