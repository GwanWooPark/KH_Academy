package com.game;

import java.util.Scanner;

public class Player extends GawiBawiBo{

    public void setSelect() {
        System.out.println("input select \n1: Gawi \n2: Bawi\n3: Bo");
        Scanner sc = new Scanner(System.in);
        super.setSelect(sc.nextInt() - 1);
    }

}
