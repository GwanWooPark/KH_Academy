package com.member.controller;


// 화면 제어(요청에 맞는 처리 후 응답)

import com.member.biz.MemberBiz;
import com.member.dto.MemberDto;
import jdk.swing.interop.SwingInterOpUtils;

import java.util.List;
import java.util.Scanner;

public class MemberController {

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

        MemberBiz biz = new MemberBiz();

        int select = 0;

        while (select != 6) {
            select = getMenu();

            switch (select) {
                case 1:
                    System.out.println("전체 출력!");
                    List<MemberDto> list = biz.selectList();
                    for (MemberDto dto : list) {
                        System.out.println(dto);
                    }
                    break;
                case 2:
                    System.out.println("선택 출력!");
                    System.out.println("출력할 번호 입력 : ");
                    int m_no = sc.nextInt();
                    MemberDto dto = biz.selectOne(m_no);
                    System.out.println(dto);
                    break;
                case 3:
                    System.out.println("추가!");
                    // 이름, 나이, 성별, 지역, 직업, 전화번호, 이메일
                    System.out.println("이름 : ");
                    String m_name = sc.next();
                    System.out.print("나이 : ");
                    int m_age = sc.nextInt();
                    System.out.print("성별 : ");
                    String m_gender = sc.next();
                    System.out.print("지역 : ");
                    String m_loc = sc.next();
                    System.out.print("직업 : ");
                    String m_job = sc.next();
                    System.out.print("전화번호 : ");
                    String m_tel = sc.next();
                    System.out.print("이메일 : ");
                    String m_email = sc.next();
                    MemberDto insertDto = new MemberDto(0, m_name, m_age, m_gender, m_loc, m_job, m_tel, m_email);

                    int insertRes = biz.insert(insertDto);
                    if (insertRes > 0) {
                        System.out.println("추가 성공!");
                    } else {
                        System.out.println("추가 실패!");
                    }
                    break;
                case 4:
                    System.out.println("수정할 번호 입력 : ");
                    m_no = sc.nextInt();
                    System.out.println("이름 : ");
                    m_name = sc.next();
                    System.out.print("나이 : ");
                    m_age = sc.nextInt();
                    System.out.print("성별 : ");
                    m_gender = sc.next();
                    System.out.print("지역 : ");
                    m_loc = sc.next();
                    System.out.print("직업 : ");
                    m_job = sc.next();
                    System.out.print("전화번호 : ");
                    m_tel = sc.next();
                    System.out.print("이메일 : ");
                    m_email = sc.next();

                    MemberDto updateDto = new MemberDto(m_no, m_name, m_age, m_gender, m_loc, m_job, m_tel, m_email);
                    int updateRes = biz.update(updateDto);

                    if (updateRes > 0) {
                        System.out.println("수정 성공!");
                    } else {
                        System.out.println("수정 실패..");
                    }
                    break;
                case 5:
                    System.out.println("삭제할 번호 입력 : ");
                    m_no = sc.nextInt();

                    int deleteRes = biz.delete(m_no);

                    if (deleteRes > 0) {
                        System.out.println("삭제 성공!");
                    } else {
                        System.out.println("삭제 실패..");
                    }
                    break;
                case 6:
                    System.out.println("프로그램을 종료합니다...");
                    break;
            }
        }
    }
}
