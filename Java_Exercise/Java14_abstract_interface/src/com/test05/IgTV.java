package com.test05;

public class IgTV implements TV{

    private int volume;

    public IgTV() {
        System.out.println("IgTV가 켜졌습니다");
    }

    @Override
    public int volumeUp() {
        volume+=3;
        return volume;
    }

    @Override
    public int volumeDown() {
        if (volume >= 3)
            volume -=3;
        else
            volume = 0;
        return volume;
    }

    public String toString() {
        return "IgTV의 현재 볼륨은" + volume;
    }
}
