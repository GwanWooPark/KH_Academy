package com.vehicle;

public class Truck extends Car{

    private int speed;

    public Truck () {
        System.out.println("국산 트럭");
    }

    public Truck(int speed) {
        System.out.println("국산 트럭");
        this.speed = speed;
    }

    @Override
    public int getSpeed() {
        return speed;
    }

    @Override
    public void setSpeed(int speed) {
        this.speed = speed;
    }

    @Override
    public void accelPedal() {
        System.out.println("속도 더 느리게 상승");
        speed+=5;
    }

    @Override
    public void breakPedal() {
        speed-=5;
        if (speed > 0) {
            System.out.println("속도 더 빨리 하락");
        } else {
            System.out.println("멈춤");
            speed = 0;
        }
    }

}
