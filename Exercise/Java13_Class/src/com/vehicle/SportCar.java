package com.vehicle;

import com.score.Score;

public class SportCar extends Car{

    public SportCar () {
        System.out.println("해외 스포츠카");
    }

    public SportCar(int speed) {
        super(speed);
        System.out.println("해외 스포츠카");
    }

    @Override
    public void accelPedal() {
        setSpeed(getSpeed() + 15);
        System.out.println("속도 더 빨리 상승");
    }
    @Override
    public void breakPedal() {
        setSpeed(getSpeed() - 15);
        if (getSpeed() > 0) {
            System.out.println("속도 더 빨리 하락");
        } else {
            System.out.println("멈춤");
            setSpeed(0);
        }
    }

    @Override
    public String toString() {
        return "현재 속도 : " + getSpeed();
    }
}
