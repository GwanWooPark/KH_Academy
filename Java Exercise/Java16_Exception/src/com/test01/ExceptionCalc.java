package com.test01;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionCalc {

    public int calculation() {

        int res = 0;

        while (true) {
            try {
                res = inputNum() / inputNum();
                break;
            } catch (InputMismatchException e) {
                System.out.println("숫자만 입력해");
                e.printStackTrace();
            } catch (ArithmeticException e) {
                System.out.println("0 나누기가 되겠냐");
                e.printStackTrace();
            }
        }
        return res;
    }

    public int inputNum() {
        System.out.print("숫자만 입력해주세요 : ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        return n;
    }
}
