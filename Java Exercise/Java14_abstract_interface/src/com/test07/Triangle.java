package com.test07;

import java.util.Scanner;

public class Triangle extends AreaImpl implements Area{


    @Override
    public void print() {
        System.out.print("삼각형의 ");
        super.print();
    }

    @Override
    public void setResult(String result) {
        super.setResult(result);
    }

    @Override
    public void make() {
        System.out.println("밑변과 높이를 입력해주세요: ");
        Scanner sc = new Scanner(System.in);

        int height = sc.nextInt();
        int base = sc.nextInt();
        double area = (double) (height * base / 2);

        setResult((area+ "").substring(0, 5));
    }
}
