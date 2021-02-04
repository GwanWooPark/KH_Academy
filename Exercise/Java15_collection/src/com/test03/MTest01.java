package com.test03;

import java.util.HashSet;
import java.util.Set;

public class MTest01 {

    public static void main(String[] args) {

        Set<String> set = new HashSet<String>();
        set.add("1");
        set.add("3");
        set.add("5");
        set.add("2");
        set.add("6");
        set.add("4");
        set.add("7");
        /*
        set.add("3");
        set.add("3");
        set.add("3");
        */
        for (String s : set) {
            System.out.println(s);
        }

        findSetElement(set, "5");
    }

    public static void findSetElement(Set<String> set, String find) {

        /*
          set은 순서가 없기 때문에 get(index) 메소드가 없다!
         */

        for (String s : set
        ) {
            if (s.equals(find))
                System.out.println(find + "찾았다");
        }
        if (set.contains(find))
            System.out.println(find + "찾았다");
    }
}
