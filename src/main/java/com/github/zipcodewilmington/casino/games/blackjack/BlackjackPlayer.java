package com.github.zipcodewilmington.casino.games.blackjack;

public class BlackjackPlayer implements PlayerInterface {
    private Hand hand = new Hand();
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
        // TODO — humans delegate to an internal CasinoAccount, bots use a plain field
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

    public void hit() {
        // TODO
    }

    public void stand() {
        // TODO
    }

    public void doubleDown() {
        // TODO
    }

    /**
     * Called internally when isBot is true, instead of reading UI/console input.
     */
    public void decideBotAction() {
        // TODO
    }
}
