package com.test05;

public class MTest {

    public static void main(String[] args) {
        TV tv = new IgTV();
        System.out.println(tv.volumeUp());
        System.out.println(tv.volumeUp());
        System.out.println(tv.volumeUp());
        System.out.println(tv.volumeDown());
        System.out.println(tv.volumeDown());
        System.out.println(tv.volumeDown());
        System.out.println(tv.toString());

        System.out.println();

        tv = new SamsongTV();
        System.out.println(tv.volumeUp());
        System.out.println(tv.volumeUp());
        System.out.println(tv.volumeUp());
        System.out.println(tv.volumeDown());
        System.out.println(tv.volumeDown());
        System.out.println(tv.volumeDown());
        System.out.println(tv.toString());

    }
}
