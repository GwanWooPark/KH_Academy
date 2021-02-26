package com.test01;

import java.util.Locale;

public class MTest01 {

    private static String str = "   The String class represents character strings.   ";
    public static char[] arr = str.toCharArray();

    public static void main(String[] args) {

        String s = "Hello";
        System.out.println(s + "World!");
        System.out.println(s);

        s = 1 + 2 + s;               //상수가 앞에 있으면 연산자 우선순위에 의해 상수+상수 후 문자열
        System.out.println(s);
        s = s + 1 + 2;
        System.out.println(s);
        //String concatenation -> String과 다른 타입이 만나게 되면, String이 된다.


        // 1. str의 길이
        prn01();

        // 2. str 전체를 대문자로 바꿔서 출력
        prn02();

        // 3. str 전체를 소문자로 바꿔서 출력
        prn03();

        // 4. str에서 첫번 째 c의 인덱스
        prn04();

        // 5. "class" 를 "java"로 바꿔서
        prn05();

        // 6. "character"를 찾아서 대문자로 바꿔서, 전체 출력
        prn06();

        // 7. str을 char[]로 출력하되, 'c'만 출력하자.
        // 그리고 c의 총 갯수 출력
        prn07();

        // 8. str을 char[]로 출력하되, 대문자만 출력
        prn08();

        // 9. str안에 있는 모든 공백을 제거 후 출력
        prn09();

        // 10. 전체를 거꾸로
        prn10();

    }

    public static void prn01() {
        System.out.println("1 .str의 길이 : " + str.length());
        System.out.println("------------------------");
    }
    public static void prn02() {
        System.out.print("대문자로만 출력 : ");
        System.out.println(str.toUpperCase(Locale.ROOT));
        System.out.println("------------------------");
    }
    public static void prn03() {
        System.out.print("소문자로만 출력 : ");
        System.out.println(str.toLowerCase(Locale.ROOT));
        System.out.println("------------------------");
    }
    public static void prn04() {
        System.out.print("str의 첫 번째 인덱스 : ");
        System.out.println(str.indexOf('T'));
        System.out.println("------------------------");
    }
    public static void prn05() {
        System.out.print("class를 java로 바꿔서 : ");
        System.out.println(str.replace("class","java"));
        System.out.println("------------------------");
    }
    public static void prn06() {
        System.out.print("character를 대문자로 바꿔서 : ");
        System.out.println(str.replace("character","CHARACTER"));
        System.out.println("------------------------");
    }
    public static void prn07() {

        int count = 0;

        System.out.print("str을 char[]로 출력하되, 'c'만 출력하자. : ");

        for (char c : arr) {
            if (c == 'c') {
                count++;
                System.out.print(c);
            }
        }
        System.out.println();
        System.out.printf("c의 총 갯수 : %d\n", count);
        System.out.println("------------------------");
    }
    public static void prn08() {

        System.out.print("str을 char[]로 출력하되 대문자만 출력 : ");

        for (int i = 0; i < arr.length; i++){
           if (Character.isUpperCase(arr[i]))
               System.out.print(arr[i]);
        }
        System.out.println();
        System.out.println("------------------------");
    }
    public static void prn09() {

        System.out.print("str의 모든 공백을 제거하고 출력 : ");
        System.out.println(str.replaceAll(" ", ""));
        System.out.println("------------------------");
    }
    public static void prn10() {

        StringBuffer sb = new StringBuffer();
        sb.append(str);

        System.out.print("str을 거꾸로 출력 : ");
        System.out.println(sb.reverse());
        System.out.println("------------------------");
    }
}
