package com.point;

import java.util.Scanner;

public class PointLength {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("x 좌표 : ");
        int x = sc.nextInt();
        System.out.print("y 좌표 : ");
        int y = sc.nextInt();

        System.out.printf("(0, 0)부터 (%d, %d)까지의 거리는 %.2f 입니다.", x, y, pLength(x, y));

    }

    // x와 y의 좌표를 입력받아 (0, 0), (x, y)까지의 직선의 거리를 리턴하는 pLength()메소드

    public static double pLength (int x, int y) {

        double res = 0;
        //res = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
        res = Math.hypot(x,y);
        return res;
    }
}
