package com.github.zipcodewilmington.casino.games.roulette;

import java.util.Scanner;

import com.github.zipcodewilmington.casino.GameInterface;

public class RouletteGame implements GameInterface {
    private RouletteWheel wheel = new RouletteWheel();
    private Scanner scanner = new Scanner(System.in);

    @Override
    public void setup() {
        System.out.println("Welcome to Roulette!");
        System.out.println(getRules());
    }

    @Override
    public void play() {
        System.out.print("Choose a number from 1 to 38: ");
        int playerNumber = scanner.nextInt();

        System.out.print("Enter your bet: $");
        double bet = scanner.nextDouble();

        System.out.println("You bet $" + bet + " on number " + playerNumber + ".");

        int result = wheel.spin();

        System.out.println("The wheel is spinning...");
        System.out.println("The ball landed on: " + result);

        if (playerNumber == result) {
            System.out.println("You win!");
        } else {
            System.out.println("You lose!");
        }
    }

    @Override
    public String getRules() {
        return "Choose a number from 1 to 38 and place your bet. "
                + "If the ball lands on your number, you win!";
    }

    @Override
    public int getMinPlayers() {
        return 1;
    }

    @Override
    public int getMaxPlayers() {
        return 1;
    }
}