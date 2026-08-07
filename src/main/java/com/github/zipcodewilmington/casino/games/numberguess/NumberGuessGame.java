package com.github.zipcodewilmington.casino.games.numberguess;

public class NumberGuessGame implements GameInterface {
    private int secretNumber;

    @Override
    public void setup() {
        secretNumber = 0;
    }

    @Override
    public void play() {
        System.out.println("Welcome to Number Guess!");
        System.out.println("Number Guess is not implemented yet. Returning to menu...");
    }

    @Override
    public String getRules() {
        return "Number Guess placeholder: welcome message only. Returning to menu.";
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