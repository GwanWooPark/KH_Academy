package com.kh.dto;

public class TestDto {

    private int no;
    private String name;
    private String phone;
    private String addr;


    public TestDto() {

    }

    public TestDto(int no, String name, String phone, String addr) {
        this.no = no;
        this.name = name;
        this.phone = phone;
        this.addr = addr;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    @Override
    public String toString() {
        return String.format("%2d %5s %10s %s", no, name, phone, addr);
    }
}


