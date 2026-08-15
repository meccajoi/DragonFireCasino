package com.github.zipcodewilmington.casino.games.numberguess;

import java.util.Random;
import java.util.Scanner;

import com.github.zipcodewilmington.casino.GameInterface;

public class NumberGuessGame implements GameInterface {

    private int secretNumber;
    private Random random = new Random();
    private Scanner scanner = new Scanner(System.in);

    @Override
    public void setup() {
        secretNumber = random.nextInt(100) + 1;
    }

    @Override
public void play() {

    System.out.println("Welcome to Number Guess!");
    System.out.println(getRules());

    boolean keepPlaying = true;

    while (keepPlaying) {

        secretNumber = random.nextInt(20) + 1;

        int guess = 0;
        int guesses = 0;

        while (guesses < 3 && guess != secretNumber) {

            System.out.print("Enter your guess: ");
            guess = scanner.nextInt();

            guesses++;

            if (guess < secretNumber) {
                System.out.println("Too low!");
            } else if (guess > secretNumber) {
                System.out.println("Too high!");
            } else {
                System.out.println("You got it!");
                System.out.println("It took you " + guesses + " guesses.");
            }
        }

        // If they used all 3 guesses and did not get it
        if (guess != secretNumber) {
            System.out.println("You are out of guesses!");
            System.out.println("The secret number was " + secretNumber + ".");
        }

        scanner.nextLine();

        System.out.print("Would you like to play again? (yes/no): ");
        String answer = scanner.nextLine();

        if (answer.equalsIgnoreCase("no") ||
            answer.equalsIgnoreCase("n")) {

            keepPlaying = false;
            System.out.println("Returning to casino menu...");
        }
    }
}

        @Override
        public String getRules() {
        return "Guess the secret number between 1 and 20. You have 3 tries.";
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