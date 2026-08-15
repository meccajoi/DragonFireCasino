package com.github.zipcodewilmington.casino.games.numberguess;

import com.github.zipcodewilmington.casino.PlayerInterface;

public class NumberGuessPlayer implements PlayerInterface {

    private String name;
    private double balance;
    private int guesses;
    private boolean isBot;

    public NumberGuessPlayer(String name, double balance, boolean isBot) {
        this.name = name;
        this.balance = balance;
        this.isBot = isBot;
        this.guesses = 0;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void placeBet(double amount) {
        balance = balance - amount;
    }

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public void setBalance(double amount) {
        balance = amount;
    }

    @Override
    public void collectWinnings(double amount) {
        balance = balance + amount;
    }

    public void guess(int number) {
        guesses++;
    }

    public void decideBotAction() {
        // Bot guessing logic can be added later
    }
}