package com.game;

public class Referee {
    public static String isWin(int ai, int player) {



        String[][] winDrawLose = {
                {"Draw","Win","Lose"},
                {"Lose","Draw","Win"},
                {"Win","Lose","Draw"}
        };

        return winDrawLose[ai][player];
    }
}
