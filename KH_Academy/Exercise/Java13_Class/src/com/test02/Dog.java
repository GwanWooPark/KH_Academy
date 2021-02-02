package com.test02;

public class Dog extends Animal{

    public Dog() {

        System.out.println("강아지");
    }

    @Override
    public void bark() {
        super.bark();
        System.out.println("왈왈");
    }
}
