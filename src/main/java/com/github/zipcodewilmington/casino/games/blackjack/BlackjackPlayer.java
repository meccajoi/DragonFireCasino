package com.github.zipcodewilmington.casino.games.blackjack;

import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.utils.Hand;

public class BlackjackPlayer implements PlayerInterface {
    private Hand hand = new Hand();
    private boolean isBot;
    private String name;
    private double balance;

    public BlackjackPlayer(String name, double balance, boolean isBot) {
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

    public void hit(Dealer dealer) {
        dealer.dealCardTo(this);
    }

    public void split(Dealer dealer) {
        dealer.dealCardTo(this);
    }

    public void stand() {
        System.out.println(name + " stands.");
    }

    public void doubleDown(Dealer dealer, double additionalBet) {
    this.placeBet(additionalBet);
    dealer.dealCardTo(this);
    this.stand();
}

   
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