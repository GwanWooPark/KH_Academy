package com.cal;
import java.util.Scanner;

/*
    서력 기원 연수가 4로 나누어 떨어지는 해는 우선 윤년으로 하고,
    그 중에서 100으로 나누어 떨어지는 해는 평년으로 하며,
    다만 400으로 나누어 떨어지는 해는 다시 윤년으로 정하였다.
 */


public class LeapYear {
    //연도를 입력받아, 입력받은 연도가 윤년이면 "xxxx년은 윤년이 맞습니다.", 아니면 아니라고 출력
    public boolean isLeapYear(int year){

        if(((year % 4 == 0)  && (year % 100 != 0)) || year % 400 == 0)
            return true;

        return false;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("연도를 입력하시오 : ");
        int year = sc.nextInt();

        LeapYear ly = new LeapYear();

        if(ly.isLeapYear(year))
            System.out.printf("%d년은 윤년이 맞습니다", year);
        else
            System.out.printf("%d년은 윤년이 아닙니다.", year);


    }

    //특정 일  = 무슨 요일 출력
    //
}
