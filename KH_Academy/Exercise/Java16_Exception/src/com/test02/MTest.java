package com.test02;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MTest {

    public static void main(String[] args) {

        int a = 0;

        try {
            System.out.println("숫자를 입력해 주세요");
            Scanner sc = new Scanner(System.in);
            a = sc.nextInt();

            if (a == 4) {
                throw new MyException("반장 4"); // 예외를 발생시킬 수 있다.
            }
        } catch (MyException e) {
            System.out.println("My Exception 발생");
            e.printStackTrace();
        } catch (InputMismatchException e) {
            System.out.println("숫자만");
            e.printStackTrace();
        } catch (ArithmeticException e) {
            System.out.println("계산 잘못");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("예외 발생");
            e.printStackTrace();
        } finally {
            System.out.println("입력한 값 : " + a);
        }

    }
}
