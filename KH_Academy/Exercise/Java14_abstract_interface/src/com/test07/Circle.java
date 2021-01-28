package com.test07;

import java.util.Scanner;

public class Circle extends AreaImpl implements Area{

    @Override
    public void print() {
        super.print();
    }

    @Override
    public void setResult(String result) {

        super.setResult(result);
    }

    @Override
    public void make() {

        System.out.println("반지름을 입력해주세요 : ");
        Scanner sc = new Scanner(System.in);

        double area = sc.nextDouble();
        area = area * area * Math.PI;

        setResult(Double.toString(area).substring(0,5));
    }
}
