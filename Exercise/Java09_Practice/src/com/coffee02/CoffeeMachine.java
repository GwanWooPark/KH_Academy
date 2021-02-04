package com.coffee02;

import java.util.Scanner;

public class CoffeeMachine {

    public void inputMoney() {

        System.out.println("돈을 넣어주세요 \n1잔당 200원");
        Scanner sc = new Scanner(System.in);
        int money = sc.nextInt();
        System.out.println("잔수를 선택해주세요");
        int coffee = sc.nextInt();

        if(money >= 200){
            makeCoffee(money, coffee);
        }
        else {
            System.out.println("금액이 부족합니다.");
        }

    }

    private void makeCoffee(int money, int coffee) {

        int change = money - coffee*200;

        System.out.println("커피" + coffee + "잔 나왔습니다");
        System.out.println("잔돈은" + change + "원 입니다.");

    }
}
