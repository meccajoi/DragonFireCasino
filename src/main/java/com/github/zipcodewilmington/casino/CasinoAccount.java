package com.github.zipcodewilmington.casino;

/**
 * Holds a persistent balance for a human player across multiple games
 * in a session. Bot players do not use this — see PlayerInterface note
 * on Person A's / whole team's design doc for the human/bot split rationale.
 */
public class CasinoAccount {
    private String owner;
    private double balance;

    public CasinoAccount(String owner) {
        // TODO
    }

    public void deposit(double amount) {
        // TODO
    }

    public boolean withdraw(double amount) {
        // TODO
        return false;
    }

    public double getBalance() {
        // TODO
        return 0;
    }

    public boolean canAfford(double amount) {
        // TODO
        return false;
    }
}
