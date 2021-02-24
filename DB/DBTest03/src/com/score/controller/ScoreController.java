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
                    System.out.println("출력할 이름 : ");
                    String name = sc.next();
                    ScoreDto dto = biz.selectOne(name);
                    System.out.println(dto);
                    break;
                case 3:
                    System.out.println("추가!");
                    // 이름, 국, 영, 수, 총점, 평균, 성적
                    System.out.print("이름 입력 : ");
                    name = sc.next();
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
                    System.out.println("수정하고자 하는 이름 입력 : ");
                    name = sc.next();
                    System.out.println("수정할 국어 점수 : ");
                    kor = sc.nextInt();
                    System.out.println("수정할 영어 점수 : ");
                    eng = sc.nextInt();
                    System.out.println("수정할 수학 점수 : ");
                    math = sc.nextInt();
                    System.out.println("수정할 총점 : ");
                    sum = sc.nextInt();
                    System.out.println("수정할 평균 : ");
                    avg = sc.nextDouble();
                    System.out.println("수정할 성적 : ");
                    grade = sc.next();

                    ScoreDto updateDto = new ScoreDto(name, kor, eng, math, sum, avg, grade);
                    int res = biz.update(updateDto);
                    if (res > 0) {
                        System.out.println("수정 성공 !");
                    } else {
                        System.out.println("수정 실패..");
                    }
                    break;
                case 5:
                    System.out.println("삭제하고자 하는 이름 입력 : ");
                    name = sc.next();

                    int deleteRes = biz.delete(name);
                    if (deleteRes > 0) {
                        System.out.println("삭제 성공!");
                    } else {
                        System.out.println("삭제 실패...");
                    }
                    break;
                case 6:
                    System.out.println("프로그램을 종료합니다 ...");
                    break;
            }
        }
    }
}
