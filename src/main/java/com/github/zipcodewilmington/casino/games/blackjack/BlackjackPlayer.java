package com.github.zipcodewilmington.casino.games.blackjack;

import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.utils.Hand;

public class BlackjackPlayer implements PlayerInterface {
    private Hand hand = new Hand();
    private boolean isBot;
    private String name;
    private double balance;

    public BlackjackPlayer(String name, boolean isBot) {
        this.name = name;
        this.isBot = isBot;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void placeBet(double amount) {
        withdraw(amount);
    }

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public void setBalance(double amount) {
        this.balance = amount;
    }

    @Override
    public void collectWinnings(double amount) {
        deposit(amount);
    }

    public Hand getHand() {
        return hand;
    }

    public boolean isBot() {
        return isBot;
    }

    /**
     * Requests one card from the given Dealer. Players never hold a
     * reference to the deck directly — only the Dealer touches it.
     */
    public void hit(Dealer dealer) {
        dealer.dealCardTo(this);
    }

    public void stand() {
        System.out.println(name + " stands.");
    }

    public void doubleDown(Dealer dealer) {
        // TODO — double the bet, take exactly one more card, then stand
        this.placeBet(balance);
        dealer.dealCardTo(this);
        this.stand();
    }

    /**
     * Called internally when isBot is true, instead of reading console input.
     * Kept simple per team's non-strategy-pattern bot design: hit if under 17.
     */
    public void decideBotAction(Dealer dealer) {
        if (this.getHandValue() < 17) {
            hit(dealer);
        } else {
            stand();
        }
    }

    public int getHandValue() {
        return BlackjackScorer.calculateHandValue(hand);
    }
}