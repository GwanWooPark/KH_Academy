package com.test01;

public class Cat extends Animal {

    // bark() -> 반드시 오버라이드해서 구현해야함
    @Override
    public void bark() {

        System.out.println("야옹");
    }

    // eat() -> 해도되고 안해도 됨.
}
