package com.test02;

import java.util.ArrayList;
import java.util.List;

public class MTest01 {

    public static void main(String[] args) {

        List<String> list = new ArrayList<String>();

        list.add("홍길동");
        list.add("이순신");
        list.add("유재석");
        list.add("조세호");
        list.add("신동엽");

        //transElement(list);

        List<Integer> ls = new ArrayList<Integer>();
        ls.add(1);
        ls.add(3);
        ls.add(4);
        ls.add(5);
        ls.add(2);
        System.out.println();
    }

    public static void transElement(List<String> list) {

        // 1.홍길동을 index를 찾아, 해당 index의 값을 김길동으로 바꾸자.

        list.set(list.indexOf("홍길동"), "김길동");
        System.out.println(list);

        // 2. ~신으로 끝나는 객체를 찾아서 "신"을 "자"로 바꾸자.

        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).endsWith("신"))
                list.set(i, list.get(i).replace("신","자"));
        }
        System.out.println(list);

        // 3. 끝 글자가 "호"인 객체를 찾아서 삭제하자.

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).endsWith("호"))
                list.remove(i);
        }
        System.out.println(list);
    }

}
