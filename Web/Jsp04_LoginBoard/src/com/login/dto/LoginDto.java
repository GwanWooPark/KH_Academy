package com.login.dto;

public class LoginDto {

    private int myNo;
    private String myId;
    private String myPw;
    private String myName;
    private String myAddr;
    private String myPhone;
    private String myEmail;
    private String myEnabled;
    private String myRole;

    public LoginDto() {
    }

    public LoginDto(int myNo, String myPw, String myAddr, String myPhone, String myEmail) {
        this.myNo = myNo;
        this.myPw = myPw;
        this.myAddr = myAddr;
        this.myPhone = myPhone;
        this.myEmail = myEmail;
    }

    public LoginDto(String myId, String myPw, String myName, String myAddr, String myPhone, String myEmail) {
        this.myId = myId;
        this.myPw = myPw;
        this.myName = myName;
        this.myAddr = myAddr;
        this.myPhone = myPhone;
        this.myEmail = myEmail;
    }

    public LoginDto(int myNo, String myId, String myPw, String myName, String myAddr, String myPhone, String myEmail, String myEnabled, String myRole) {
        this.myNo = myNo;
        this.myId = myId;
        this.myPw = myPw;
        this.myName = myName;
        this.myAddr = myAddr;
        this.myPhone = myPhone;
        this.myEmail = myEmail;
        this.myEnabled = myEnabled;
        this.myRole = myRole;
    }

    public int getMyNo() {
        return myNo;
    }

    public void setMyNo(int myNo) {
        this.myNo = myNo;
    }

    public String getMyId() {
        return myId;
    }

    public void setMyId(String myId) {
        this.myId = myId;
    }

    public String getMyPw() {
        return myPw;
    }

    public void setMyPw(String myPw) {
        this.myPw = myPw;
    }

    public String getMyName() {
        return myName;
    }

    public void setMyName(String myName) {
        this.myName = myName;
    }

    public String getMyAddr() {
        return myAddr;
    }

    public void setMyAddr(String myAddr) {
        this.myAddr = myAddr;
    }

    public String getMyPhone() {
        return myPhone;
    }

    public void setMyPhone(String myPhone) {
        this.myPhone = myPhone;
    }

    public String getMyEmail() {
        return myEmail;
    }

    public void setMyEmail(String myEmail) {
        this.myEmail = myEmail;
    }

    public String getMyEnabled() {
        return myEnabled;
    }

    public void setMyEnabled(String myEnabled) {
        this.myEnabled = myEnabled;
    }

    public String getMyRole() {
        return myRole;
    }

    public void setMyRole(String myRole) {
        this.myRole = myRole;
    }
}
