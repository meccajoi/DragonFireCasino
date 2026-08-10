package com.github.zipcodewilmington.casino.games.poker;

import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.utils.Hand;

public class PokerPlayer implements PlayerInterface {
    private Hand hand = new Hand();
    private double bet;
    private boolean isBot;

    @Override
    public String getName() {
        // TODO
        return null;
    }

    @Override
    public void placeBet(double amount) {
        // TODO
    }

    @Override
    public double getBalance() {
        // TODO
        return 0;
    }

    @Override
    public void setBalance(double amount) {
        // TODO
    }

    @Override
    public void collectWinnings(double amount) {
        // TODO
    }

    public void fold() {
        // TODO
    }

    public void call() {
        // TODO
    }

    public void raise(double amount) {
        // TODO
    }

    public void decideBotAction() {
        // TODO
    }
}
