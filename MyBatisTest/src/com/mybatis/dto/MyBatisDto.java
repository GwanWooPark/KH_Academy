package com.mybatis.dto;

public class MyBatisDto {

    private int num;
    private String str;

    public MyBatisDto() {
    }

    public MyBatisDto(int num, String str) {
        this.num = num;
        this.str = str;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }
}
