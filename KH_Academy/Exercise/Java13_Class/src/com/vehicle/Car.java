package com.vehicle;

import com.test02.Cat;

public class Car {

    private int speed;

    public Car() {
    }

    public Car(int speed) {

        this.speed = speed;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void accelPedal() {
        System.out.println("속도 상승");
        speed+=10;
    }
    public void breakPedal() {
        speed-=10;
        if (speed > 0) {
            System.out.println("속도 하락");
        } else {
            System.out.println("멈춤");
            speed = 0;
        }
    }

    @Override
    public String toString() {
        return "현재 속도 : " + speed;
    }
}
