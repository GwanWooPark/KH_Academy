package com.test05;

public class SamsongTV implements TV{

    private int volume;

    public SamsongTV() {
        System.out.println("SamsongTV가 켜졌습니다");
    }

    @Override
    public int volumeUp() {
        volume+=5;
        return volume;
    }

    @Override
    public int volumeDown() {
        if (volume >= 5)
            volume -=5;
        else
            volume = 0;
        return volume;
    }

    public String toString() {
        return "SamsongTV의 현재 볼륨은" + volume;
    }
}
