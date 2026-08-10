package com.github.zipcodewilmington.casino.games.roulette;

import com.github.zipcodewilmington.casino.PlayerInterface;

public class RoulettePlayer implements PlayerInterface {
    private String name;
    private double balance;
    private double bet;
    private boolean isBot;

    public RoulettePlayer(String name, double balance, boolean isBot) {
        this.name = name;
        this.balance = balance;
        this.isBot = isBot;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void placeBet(double amount) {
        bet = amount;
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

    public double getBet() {
        return bet;
    }

    public boolean isBot() {
        return isBot;
    }

    public void decideBotAction() {
        if (isBot) {
            System.out.println(name + " is deciding what to bet.");
        }
    }
}