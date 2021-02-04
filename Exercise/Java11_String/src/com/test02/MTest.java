package com.test02;

public class MTest {

    // string을 +연산할 떄, 내부적으로는 StringBuilder로 변환하여 연산함. (jdk 1.5)
    public static void main(String[] args) {
    //    stringTest();
        stringBufferTest();
    }
    public static void stringBufferTest() {

        // mutable
        StringBuffer sb = new StringBuffer();
        sb.append("안녕하세요! ")
          .append("저는 ")
          .append("박관우 입니다."); // method chaining

        System.out.println(sb);
        System.out.println(sb.hashCode());

        sb.replace(0,5,"하이");
        System.out.println(sb);
        System.out.println(sb.hashCode());

        sb.reverse();
        System.out.println(sb);
        System.out.println(sb.hashCode());
    }

    public static void stringTest() {

        // immutable
        String s = "안녕하세요!";
        s+= "저는 ";
        s+= "박관우 입니다.";

        System.out.println(s);
        System.out.println(s.hashCode());


        // immutable이라 바뀌지 않는다.
        s.replace("안녕하세요!", "하이!");
        System.out.println(s);
        // s에 대입하지 않으면 변하지 않는다.(만들어져 있기는 하다.)
        s = s.replace("안녕하세요!", "하이!");
        System.out.println(s);
    }
}
