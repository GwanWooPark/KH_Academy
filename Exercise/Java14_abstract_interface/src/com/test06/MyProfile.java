package com.test06;

public class MyProfile extends Profile implements Display, Job{

    private String loc;

    // 기본 생성자 안되는 이유 뭘까?
    // 생성자를 오버로딩해서 구현해 놓는다면 컴파일러가 기본 생성자를 생성하지 않음.
    // java 규칙 중 상위클래스에 기본 생성자가 없는 클래스를 상속받는 경우 슈퍼클래스의 생성자를 호출해야 된다는 규칙이 있습니다.

    public MyProfile(String name, String phone) {

        super(name, phone);
    }

    // setter의 기능을 하는 중임
    @Override
    public void JobLoc(String loc) {

        this.loc = loc;
    }

    @Override
    public void printProfile() {

        super.printProfile();
    }

    @Override
    public void display() {
        super.printProfile();
        System.out.println("회사 주소 : " + loc);
        System.out.println("직무 : " + JOB_ID);
        // super.JOB_ID -> super는 부모 "객체" / JOB_ID는 인터페이스 꺼라서 super 사용 불가.
        // Job.JOB_ID로 사용해야함.
    }
}
