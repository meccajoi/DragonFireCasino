package com.github.zipcodewilmington.casino.games.roulette;

import java.util.Random;

public class RouletteWheel {
    private Random random = new Random();

    public String spin() {
        int result = random.nextInt(38);

        if (result == 0) {
            return "0";
        }

        if (result == 37) {
            return "00";
        }

        return String.valueOf(result);
    }

    public String getColor(String number) {
        if (number.equals("0") || number.equals("00")) {
            return "GREEN";
        }

        int value = Integer.parseInt(number);

        if (value == 1 || value == 3 || value == 5 ||
            value == 7 || value == 9 || value == 12 ||
            value == 14 || value == 16 || value == 18 ||
            value == 19 || value == 21 || value == 23 ||
            value == 25 || value == 27 || value == 30 ||
            value == 32 || value == 34 || value == 36) {

            return "RED";
        }

        return "BLACK";
    }
}