package com.github.zipcodewilmington.casino.games.slots;

import java.util.Random;

public class SlotMachine {
    private int[] reels = new int[3];
    private Randon random = new Random();

    public int[] spin() {
      
        for (int i = 0; i < reels.length; i++) {
            reels[i] = random.nextInt(6) + 1;
      }
        return reels;
    }

    public double getPayout() {

    if (reels[0] == reels[1] && reels[1] == reels[2]) {
        return 100;
    }

    if (reels[0] == reels[1] ||
        reels[0] == reels[2] ||
        reels[1] == reels[2]) {
            return 20;
}
    return 0;

    }
}
