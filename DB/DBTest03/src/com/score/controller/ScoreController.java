package com.score.controller;

import com.score.biz.ScoreBiz;
import com.score.biz.ScoreBizImpl;
import com.score.dto.ScoreDto;

import java.util.List;
import java.util.Scanner;

public class ScoreController {

    private static Scanner sc = new Scanner(System.in);

    public static int getMenu() {


        StringBuffer sb = new StringBuffer();
        sb.append("**********\n")
                .append("1. 전체 출력\n")
                .append("2. 선택 출력\n")
                .append("3. 추    가\n")
                .append("4. 수    정\n")
                .append("5. 삭    제\n")
                .append("6. 종    료\n")
                .append("input select \n");
        System.out.println(sb);

        int select = sc.nextInt();

        return select;
    }

    public static void main(String[] args) {

        ScoreBizImpl biz = new ScoreBizImpl();

        int select = 0;

        while (select != 6) {
            select = getMenu();

            switch (select) {
                case 1:
                    System.out.println("전체 출력");
                    List<ScoreDto> list = biz.selectList();
                    for (ScoreDto dto : list) {
                        System.out.println(dto);
                    }
                    break;
                case 2:
                    break;
                case 3:
                    System.out.println("추가!");
                    // 이름, 국, 영, 수, 총점, 평균, 성적
                    System.out.print("이름 입력 : ");
                    String name = sc.next();
                    System.out.print("국어 점수 : ");
                    int kor = sc.nextInt();
                    System.out.print("영어 점수 : ");
                    int eng = sc.nextInt();
                    System.out.print("수학 점수 : ");
                    int math = sc.nextInt();
                    System.out.print("총점 : ");
                    int sum = sc.nextInt();
                    System.out.print("평균 : ");
                    double avg = sc.nextDouble();
                    System.out.print("성적 : ");
                    String grade = sc.next();

                    ScoreDto insertDto = new ScoreDto(name, kor, eng, math, sum, avg, grade);

                    int insertRes = biz.insert(insertDto);
                    if (insertRes > 0) {
                        System.out.println("추가 성공");
                    } else {
                        System.out.println("추가 실패");
                    }
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
            }
        }
    }
}
