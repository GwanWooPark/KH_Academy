package com.test07;

import java.util.Scanner;

public class Square extends AreaImpl implements Area{
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
        System.out.println("가로와 세로의 길이를 입력하세요 : ");
        Scanner sc = new Scanner(System.in);

        int height = sc.nextInt();
        int base = sc.nextInt();
        int area = height * base;

        setResult(Integer.toString(area));
    }
}
