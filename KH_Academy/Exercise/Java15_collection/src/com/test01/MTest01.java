package com.test01;

import java.util.Vector;

public class MTest01 {

    public static void main(String[] args) {
        // Vector

        Vector<Integer> v = new Vector<Integer>(10, 5);
        System.out.println(v.size() + " : " + v.capacity());

        for (int i = 0; i < 9; i++) {
            v.add(i);
        }
        System.out.println(v.size() + " : " + v.capacity());
        System.out.println(v);
        v.add(9);
        System.out.println(v.size() + " : " + v.capacity());
        System.out.println(v);

        v.add(10);
        System.out.println(v.size() + " : " + v.capacity());
        System.out.println(v);

        Vector vector = new Vector();
        vector.add("1");
        vector.add(2);
        vector.add(3);

        System.out.println(vector);

    }
}
