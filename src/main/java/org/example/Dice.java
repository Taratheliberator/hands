package org.example;

import java.util.Random;

class Dice {
    private static Random random = new Random();

    public static int roll() {
        return random.nextInt(6) + 1;
    }
}
