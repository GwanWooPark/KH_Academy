package com.test06;

public interface Job {

    // Interface 안의 변수는 자동 상수화 = static final
    public String JOB_ID = "IT"; //static final 변수
                                 // 변수에 final이 붙으면 불변
                                // class나 method에 붙으면 상속 불가능
    public void JobLoc(String loc);
}

