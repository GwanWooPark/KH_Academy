package com.test05;

public interface TV {

    int volumeUp();
    int volumeDown();

    /*
      1. IgTV class
       - private int volume;
       - volumeUp() 메서드 현재 볼륨 +3
       - volumeDown() 메서드 현재 볼륨 -3
       - toString() 메서드 "IgTV의 현재 볼륨은 %d"
       - 생성자가 호출될 시, IgTV가 켜졌습니다.


       SamsongTV class
       - private int volume;
       - volumeUp() 메서드 현재 볼륨 +5
       - volumeDown() 메서드 현재 볼륨 -5
       - toString() 메서드 "SamsongTV의 현재 볼륨은 %d"
       - 생성자가 호출될 시, SamsongTV가 켜졌습니다.
     */
}
