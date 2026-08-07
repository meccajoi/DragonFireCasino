package com.github.zipcodewilmington.casino.games.slots;

import com.github.zipcodewilmington.casino.PlayerInterface;

public class SlotsPlayer implements PlayerInterface {
    private String name;
    private double balance;
    private double bet;
    private boolean isBot;

    public SlotsPlayer(String name, double balance, boolean isBot) {
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

    public void spin() {
       System.out.println(name + " spins the slot machine.");
    }

    public void decideBotAction() {
        if (isBot) {
            System.out.println(name + " is deciding what to do.");
        }
    }
}
