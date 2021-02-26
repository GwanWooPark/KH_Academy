package com.test04;

public class MTest {

    public static void main(String[] args) {
        Cat cat = new Cat();
        cat.bark();
        cat.eat("참치");

        Dog dog = new Dog();
        dog.bark();
        dog.eat("개껌");

        Eagle eagle = new Eagle();
        eagle.bark();
        eagle.eat("벌레");
        eagle.fly();
    }
}
