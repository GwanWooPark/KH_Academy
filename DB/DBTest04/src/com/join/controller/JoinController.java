package com.join.controller;

import com.join.biz.JoinBizImpl;
import com.join.dto.JoinDto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JoinController {

    private static Scanner sc = new Scanner(System.in);

    public static int getMenu() {


        StringBuffer sb = new StringBuffer();
        sb.append("**********\n")
                .append("1. 전체 출력\n")
                .append("2. 선택 출력\n")
                .append("3. 추    가\n")
                .append("4. 수    정\n")
                .append("5. 삭    제\n")
                .append("5. 삭    제\n")
                .append("6. 1등 출력\n")
                .append("7. 2등 출력\n")
                .append("8. 3등 출력\n")
                .append("9. 종   료\n")
                .append("input select \n");
        System.out.println(sb);

        int select = sc.nextInt();

        return select;
    }

    public static void main(String[] args) {

        JoinBizImpl biz = new JoinBizImpl();

        int select = 0;

        while (select != 9) {
            select = getMenu();

            switch (select) {
                case 1:
                    System.out.println("전체 출력");
                    List<JoinDto> list = new ArrayList<JoinDto>();
                    list = biz.selectList();
                    for (JoinDto dto : list){
                        System.out.println(dto);
                    }
                    break;
                case 2:
                    System.out.println("선택 출력");
                    JoinDto dto = new JoinDto();
                    System.out.println("출력할 번호 : ");
                    int m_no = sc.nextInt();
                    dto = biz.selectOne(m_no);
                    break;
                case 3:
                    System.out.println("추가");
                    System.out.println("추가할 이름 : ");
                    String name = sc.next();
                    System.out.print("국어 점수 : ");
                    int kor = sc.nextInt();
                    System.out.print("영어 점수 : ");
                    int eng = sc.nextInt();
                    System.out.print("수학 점수 : ");
                    int math = sc.nextInt();
                    JoinDto insertScore = new JoinDto(name, kor, eng, math);
                    int insertScore_res = biz.insertScore(insertScore);
                    System.out.print("나이 : ");
                    int age = sc.nextInt();
                    System.out.print("성벌 : ");
                    String gender = sc.next();
                    System.out.print("위치 : ");
                    String loc = sc.next();
                    System.out.print("직업 : ");
                    String job = sc.next();
                    System.out.print("번호 : ");
                    String tel = sc.next();
                    System.out.print("이메일 : ");
                    String email = sc.next();
                    JoinDto insertMember = new JoinDto(0, name, age, gender, loc, job, tel, email);
                    int insertMember_res = biz.insertMember(insertMember);
                    if (insertScore_res > 0) {
                        System.out.println("점수 추가 성공!");
                    } else {
                        System.out.println("추가 실패!");
                    }
                    break;
                case 4:
                    System.out.println("수정");
                    break;
                case 5:
                    System.out.println("삭제");
                    break;
                case 6:
                    System.out.println("1등 출력");
                    JoinDto dto1st = new JoinDto();
                    dto1st = biz.topNproc(1);
                    System.out.println(dto1st);
                    break;
                case 7:
                    JoinDto dto2nd = new JoinDto();
                    dto2nd = biz.topNproc(2);
                    System.out.println(dto2nd);
                    System.out.println("2등 출력");
                    break;
                case 8:
                    JoinDto dto3rd = new JoinDto();
                    dto3rd = biz.topNproc(3);
                    System.out.println(dto3rd);
                    System.out.println("3등 출력");
                    break;
                case 9:
                    System.out.println("프로그램을 종료 합니다...");
                    break;
            }
        }
    }
}
