package com.test01;

public class Dog extends Animal{
    @Override
    public void bark() {
        System.out.println("왈왈");
    }

    @Override
    public void eat(String feed) {
        System.out.println("멍멍이가 ");
        super.eat(feed);
    }
}
