package com.test01;

import java.util.Vector;

public class MTest02 {

    public static void main(String[] args) {

        Vector<String> v = new Vector<String>();
        v.add("모두한");
        v.add("박관우");
        v.add("박태영");
        v.add("백주환");
        v.add("안재웅");

        // 주소 값이 나오지 않는 것을 보아 toString이 오버라이드 되어있다고 볼 수 있다.
        //System.out.println(v);
        //prnVector(v);
        transElement(v);

    }
    public static void transElement(Vector<String> v) {
        // 1. 홍길동의 Index를 찾아, 해당 Index의 값을 홍길순으로 바꿔라

        v.set(v.indexOf("박태영"), "박태순");
        System.out.println(v);

        // 2. ~신으로 끝나는 객체를 찾아서, 만일 있으면 "신"을 "자"로 바꾸자.
        for (int i = 0; i < v.size(); i++) {
            if (v.get(i).endsWith("우")){
                v.set(i, v.get(i).replace("우","자"));
            }
        }
        System.out.println(v);
        // 3. 마지막 글자가 "호"인 객체를 찾아서, 만일 있으면 삭제하자.
        /*for (String s : v) {
            java.util.ConcurrentModificationException
            if (v.get(i).endsWith("웅")){
                v.remove(i);
            }
        }*/

        for (int i = 0; i < v.size(); i++) {
            if (v.get(i).endsWith("웅")){
                v.remove(i);
            }
        }


        System.out.println(v);
    }

    public static void prnVector(Vector<String> v) {

        //<홍길동 이순신 .... 조세호> 형태로 출력
        System.out.print("< ");
/*        for (int i = 0; i < v.size(); i++)
            System.out.print(v.get(i) + " ");*/

        // 향상된 for문 (forEach 문)
        for (String s : v) {
            System.out.print(s + " ");
        }
        System.out.println(">");
    }
}
