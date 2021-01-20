package com.test01;

import java.util.Random;

public class LottoProgram {

    public static void main(String[] args) {
        Random random = new Random();
        int bound = 45; // 랜덤 숫자 범위

        int[] Lnum = {0, 0, 0, 0, 0, 0}; //로또 함수가 들어갈 배열
        for (int i = 0; i < Lnum.length; i++){
            Lnum[i] = random.nextInt(bound) + 1; // 0이나오지 않게하기 위함 1 ~ 45
            for (int j = 0; j < i; j++) {
                if (Lnum[i] == Lnum[j]) {
                    i--;
                    break;
                }

                if(Lnum[i] < Lnum[j]){
                    int tmp = Lnum[j];
                    Lnum[j] = Lnum[i];
                    Lnum[i] = tmp;
                }
            }
        }

        for (int i = 0; i < 6; i++)
            System.out.println(Lnum[i]);

    }

}
