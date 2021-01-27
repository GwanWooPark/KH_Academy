package com.vehicle;

public class MTest {

    public static void main(String[] args) {
        /*
          1. Car을 상속받는 SportCar class를 만들자.
             기본 생성자와, 파라미터 1개짜리 생성자를 만들자.
             accelPedal과 breakPedal을 overriding하여, speed는 15씩 증감, "속도가 더 빨리 증가/ 속도가 더 빨리 감소"

          2. Car를 상속받는 Truck class 만들자.
             기본 생성자와, 파라미터 1개짜리 생성자.
              accelPedal과 breakPedal을 overriding하여, speed는 5씩 증감, "속도가 더 느리게 증가/ 속도가 더 느리게 감소"

          3. MTest에서 실행
         */

        Car c1 = new SportCar();
        c1.accelPedal();
        c1.accelPedal();
        System.out.println(c1);
        c1.breakPedal();
        c1.breakPedal();
        c1.breakPedal();


        Car c2 = new Truck(100);
        c2.accelPedal();
        c2.accelPedal();
        System.out.println(c2);
        c2.breakPedal();
        c2.breakPedal();
        c2.breakPedal();
    }
}
