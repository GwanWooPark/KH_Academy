package com.kh.controller;

import com.kh.biz.TestBiz;
import com.kh.dto.TestDto;

import java.util.List;
import java.util.Scanner;

public class TestController{

    private static Scanner sc = new Scanner(System.in);

    public static int getMenu() {
        StringBuffer sb = new StringBuffer();
        int select = 0;

        sb.append("1. 전체출력\n")
          .append("2. 선택출력\n")
          .append("3. 추가\n")
          .append("4. 수정\n")
          .append("5. 삭제\n")
          .append("6. 종료\n")
          .append("번호선택 : ");
        System.out.println(sb);
        select = sc.nextInt();
        return select;
    }

    public static void main(String[] args) {
        int select = 0;
        TestBiz biz = new TestBiz();

        while (select != 6) {
            select = getMenu();
            switch (select) {
                case 1:
                    List<TestDto> list = biz.selectList();
                    for (TestDto dto : list) {
                        System.out.println(dto);
                    }
                    break;
                case 2:
                    int no = 0;
                    System.out.print("출력할 번호 : ");
                    no = sc.nextInt();
                    TestDto selectOne = new TestDto();
                    selectOne = biz.selectOne(no);
                    System.out.println(selectOne);
                    break;
                case 3:
                    System.out.print("번호 : ");
                    no = sc.nextInt();
                    System.out.print("이름 : ");
                    String name = sc.next();
                    System.out.print("전화번호 : ");
                    String phone = sc.next();
                    System.out.print("주소 : ");
                    String addr = sc.next();
                    TestDto insertDto = new TestDto(no, name, phone, addr);
                    int insertRes = biz.insert(insertDto);
                    if (insertRes > 0) {
                        System.out.println("추가 성공");
                    } else {
                        System.out.println("추가 실패");
                    }
                    break;
                case 4:
                    System.out.print("변경할 숫자 : ");
                    no = sc.nextInt();
                    System.out.print("이름 : ");
                    name = sc.next();
                    System.out.print("전화번호 : ");
                    phone = sc.next();
                    System.out.print("주소 : ");
                    addr = sc.next();
                    TestDto updateDto = new TestDto(no, name, phone, addr);
                    int updateRes = biz.update(updateDto);
                    if (updateRes > 0) {
                        System.out.println("수정 성공");
                    } else {
                        System.out.println("수정 실패");
                    }
                    break;
                case 5:
                    System.out.print("삭제할 번호 : ");
                    no = sc.nextInt();
                    int deleteRes = biz.delete(no);
                    if (deleteRes > 0) {
                        System.out.println("삭제 성공");
                    } else {
                        System.out.println("삭제 실패");
                    }
                    break;
                case 6:
                    break;
            }
        }

    }
}
