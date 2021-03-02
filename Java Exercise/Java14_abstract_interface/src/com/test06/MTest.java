package com.test06;

public class MTest {
    public static void main(String[] args) {
        // MyProfile my  = new MyProfile();
        // 원래 이렇게 선언하게 된다면 기본 생성자가 호출되어야하는데
        // 기본 생성자가 없기 때문에 오류가 나게 된다.

        MyProfile my = new MyProfile("박관우","010-6319-4712");
        my.JobLoc("서울시 강남구"); // MyProfile JobLoc에 파라미터전달
        my.display();
    }
}
