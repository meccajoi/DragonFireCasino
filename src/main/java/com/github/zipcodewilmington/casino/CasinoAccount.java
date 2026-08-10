package com.github.zipcodewilmington.casino;
/**
 * Holds a persistent balance for a human player across multiple games
 * in a session. Bot players do not use this — see PlayerInterface note
 * on Person A's / whole team's design doc for the human/bot split rationale.
 */
public class CasinoAccount {
    private String name;
    private double balance;

    public CasinoAccount(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }
    public String getName() {
        return name;
    }

    public void deposit(double amount) {
    balance = balance + amount;
    }

    public boolean withdraw(double amount) {
        if (canAfford(amount)) {
        balance = balance - amount;
        return true;
        }
        return false;
    }

    public double getBalance() {
        return balance;
    }

    public boolean canAfford(double amount) {
        return balance >= amount;
    }
}
