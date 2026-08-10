package com.github.zipcodewilmington.casino.games.trivia;

public class Question {
    public enum Difficulty {
        EASY(1), MEDIUM(3), HARD(5);

        private final int reward;

        Difficulty(int reward) {
            this.reward = reward;
        }

        public int getReward() {
            return reward;
        }
    }

    private final String prompt;
    private final String[] choices;
    private final char correctAnswer;
    private final Difficulty difficulty;

    public Question(String prompt, String[] choices, char correctAnswer, Difficulty difficulty) {
        this.prompt = prompt;
        this.choices = choices;
        this.correctAnswer = Character.toUpperCase(correctAnswer);
        this.difficulty = difficulty;
    }

    public String prompt() {
        return prompt;
    }

    public String[] choices() {
        return choices;
    }

    public char correctAnswer() {
        return correctAnswer;
    }

    public Difficulty difficulty() {
        return difficulty;
    }
}