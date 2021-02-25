package com.join.dto;

public class JoinDto {

    private int m_no;
    private String m_name;
    private int m_age;
    private String m_gender;
    private String m_location;
    private String m_job;
    private String m_tel;
    private String m_email;
    private String s_name;
    private int s_kor;
    private int s_eng;
    private int s_math;
    private int s_sum;
    private double s_avg;
    private String s_grade;



    // 기본 생성자
    public JoinDto() {
    }

    // 생성자

    public JoinDto(int m_no, String m_name, int m_age, String m_gender, String m_location, String m_job,
                   String m_tel, String m_email, String s_name, int s_kor, int s_eng, int s_math, int s_sum,
                   double s_avg, String s_grade) {
        this.m_no = m_no;
        this.m_name = m_name;
        this.m_age = m_age;
        this.m_gender = m_gender;
        this.m_location = m_location;
        this.m_job = m_job;
        this.m_tel = m_tel;
        this.m_email = m_email;
        this.s_name = s_name;
        this.s_kor = s_kor;
        this.s_eng = s_eng;
        this.s_math = s_math;
        this.s_sum = s_sum;
        this.s_avg = s_avg;
        this.s_grade = s_grade;
    }

    public int getM_no() {
        return m_no;
    }

    public void setM_no(int m_no) {
        this.m_no = m_no;
    }

    public String getM_name() {
        return m_name;
    }

    public void setM_name(String m_name) {
        this.m_name = m_name;
    }

    public int getM_age() {
        return m_age;
    }

    public void setM_age(int m_age) {
        this.m_age = m_age;
    }

    public String getM_gender() {
        return m_gender;
    }

    public void setM_gender(String m_gender) {
        this.m_gender = m_gender;
    }

    public String getM_location() {
        return m_location;
    }

    public void setM_location(String m_location) {
        this.m_location = m_location;
    }

    public String getM_job() {
        return m_job;
    }

    public void setM_job(String m_job) {
        this.m_job = m_job;
    }

    public String getM_tel() {
        return m_tel;
    }

    public void setM_tel(String m_tel) {
        this.m_tel = m_tel;
    }

    public String getM_email() {
        return m_email;
    }

    public void setM_email(String m_email) {
        this.m_email = m_email;
    }

    public String getS_name() {
        return s_name;
    }

    public void setS_name(String s_name) {
        this.s_name = s_name;
    }

    public int getS_kor() {
        return s_kor;
    }

    public void setS_kor(int s_kor) {
        this.s_kor = s_kor;
    }

    public int getS_eng() {
        return s_eng;
    }

    public void setS_eng(int s_eng) {
        this.s_eng = s_eng;
    }

    public int getS_math() {
        return s_math;
    }

    public void setS_math(int s_math) {
        this.s_math = s_math;
    }

    public int getS_sum() {
        return s_sum;
    }

    public void setS_sum(int s_sum) {
        this.s_sum = s_sum;
    }

    public double getS_avg() {
        return s_avg;
    }

    public void setS_avg(double s_avg) {
        this.s_avg = s_avg;
    }

    public String getS_grade() {
        return s_grade;
    }

    public void setS_grade(String s_grade) {
        this.s_grade = s_grade;
    }

    @Override
    public String toString() {
        return  m_no +
                "\t " + m_name +
                "\t " + m_age +
                "\t " + m_gender +
                "\t " + m_location +
                "\t " + m_job +
                "\t " + m_tel +
                "\t " + m_email +
                "\t " + s_name +
                "\t " + s_kor +
                "\t " + s_eng +
                "\t " + s_math +
                "\t " + s_sum +
                "\t " + s_avg +
                "\t " + s_grade;
    }
}
