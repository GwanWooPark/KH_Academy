package com.test07;

import java.util.Scanner;

public class Circle extends AreaImpl implements Area{

    @Override
    public void print() {
        System.out.print("원의 ");
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

        int r = sc.nextInt();

        double res = Math.pow(r,2) * Math.PI;

        setResult((res+ "").substring(0, 5));
    }
}
