package com.test04;

import javax.swing.*;
import javax.swing.text.html.HTMLDocument;
import java.util.*;

public class MTest {

    public static void main(String[] args) {

        Map<Integer, String> map = new HashMap<Integer, String>();
        /*
           Map - 순서(X), 중복(Key(X), Value(O))
         */

        for (int i = 111; i < 116; i++) {
            map.put(i, i + "abc");
        }
       // System.out.println(map);
        map.put(112, "115abc");

      //  System.out.println(map);

        printMap(map);
    }

    public static void printMap(Map<Integer, String> map) {

        // key만 출력
        Set<Integer> keys = map.keySet();
        System.out.println(keys);
        System.out.println(map.keySet());


        // value만 출력
        Collection<String> values = map.values();
        System.out.println(values);
        System.out.println(map.values());


        // key가 111인 value출력
        System.out.println(map.get(111));

        // Entry : key와 value를 한번에 관리하는 map과 달리 key, value 각각을 관리한다.
        // map<key, value> : get(key) -> value 리턴
        // Entry : getKey(), getValue 따로

       /* Set<Map.Entry<Integer, String>> entrySet = map.entrySet();

        for (Map.Entry<Integer, String> entry : entrySet) {
            System.out.printf("%d : %s \n", entry.getKey(), entry.getValue());
        }
*/
        // key가 111인 요소의 key와 value를 각각 출력.

        System.out.println("--------------------------------------------");
        int key = 111;
        Set<Map.Entry<Integer, String>> test = map.entrySet();
        Iterator<Map.Entry<Integer, String>> ir = test.iterator();

        while (ir.hasNext()) {
            Map.Entry<Integer, String> entry = ir.next();
            if (entry.getKey() == key) {
                System.out.println(key + " : " + entry.getValue());
            }
        }
    }
}
