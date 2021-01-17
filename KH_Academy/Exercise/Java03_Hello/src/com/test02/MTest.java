package com.test02;

public class MTest {
    public static void main(String[] args) {
        FruitBasket bananaBasket = new FruitBasket();
        bananaBasket.basketSetting("바나나", 10);
        bananaBasket.fruitCount = 50;
        System.out.println(bananaBasket.fruitCount);


        FruitBasket appleBasket = new FruitBasket();
        appleBasket.basketSetting("사과", 30);
        System.out.println(appleBasket.fruitCount);
    }
}
