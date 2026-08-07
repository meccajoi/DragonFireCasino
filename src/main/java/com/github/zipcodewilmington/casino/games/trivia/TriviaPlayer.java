package com.github.zipcodewilmington.casino.games.trivia;

import com.github.zipcodewilmington.casino.PlayerInterface;

public class TriviaPlayer implements PlayerInterface {
    private final String name;
    private double balance;
    private int correctCount;
    private int wrongCount;

    private static final int MAX_STRIKES = 3;

    public TriviaPlayer(String name) {
        this.name = (name == null || name.trim().isEmpty()) ? "Player" : name.trim();
        this.balance = 0.0;
        this.correctCount = 0;
        this.wrongCount = 0;
    }

    public void recordCorrect(Question.Difficulty difficulty) {
        correctCount++;
        collectWinnings(difficulty.getReward());
    }

    public void recordWrong() {
        wrongCount++;
    }

    public boolean isEliminated() {
        return wrongCount >= MAX_STRIKES;
    }

    public int getCorrectCount() {
        return correctCount;
    }

    public int getWrongCount() {
        return wrongCount;
    }

    public int getStrikesRemaining() {
        return MAX_STRIKES - wrongCount;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void placeBet(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
        }
    }

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public void setBalance(double amount) {
        balance = Math.max(0.0, amount);
    }

    @Override
    public void collectWinnings(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }
}