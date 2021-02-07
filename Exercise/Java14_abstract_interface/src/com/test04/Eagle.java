package com.test04;

public class Eagle extends Animal implements Bird{ // class가 먼저임, 이유는 class는 하나만 상속 가능하나 인터페이스는 다중상속이 가능하기 때문에
    @Override
    public void bark() {
        System.out.println("독술");
    }

    @Override
    public void fly() {
        System.out.println("파닥파닥");
    }
}
