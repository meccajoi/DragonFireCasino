package com.github.zipcodewilmington.casino.games.trivia;

public enum Difficulty {
    EASY(1),
    MEDIUM(3),
    HARD(5);

    private final int reward;

    Difficulty(int reward) {
        this.reward = reward;
    }

    public int getReward() {
        return reward;
    }
}