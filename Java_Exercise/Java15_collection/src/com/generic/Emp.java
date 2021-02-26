package com.generic;

// <> : generic -> 타입 강제
// T : type / E : element / K : key / V : value
<<<<<<< HEAD
=======

>>>>>>> 9876ed39e8c1c8d068b5d5ea91e8ee538e68d192
public class Emp<T> {

    private T empno;
    private String ename;

    public Emp() {

    }

    public Emp(T empno, String ename) {
        this.empno = empno;
        this.ename = ename;
    }

    public T getEmpno() {

        return empno;
    }
    public void setEmpno(T empno){
        this.empno = empno;
    }
    public String getEname(){
        return ename;
    }
    public void setEname(String ename) {
        this.ename = ename;
    }

    public String toString() {
        return empno + " : " + ename;
    }
}
