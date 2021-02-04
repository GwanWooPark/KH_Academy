package com.test01;

import java.util.Scanner;

public class MTest02 {
    public static void main(String[] args) {
        test01();
    }

    public static void test01() {
        Scanner sc = new Scanner(System.in);

        System.out.print("아무거나 입력 : ");
        String token = sc.next();
        System.out.println(token);

        String token2 = sc.next();
        System.out.println(token2);

        String token3 = sc.next();
        System.out.println(token3);


        String line = sc.nextLine();
        System.out.println(line);
    }
}
