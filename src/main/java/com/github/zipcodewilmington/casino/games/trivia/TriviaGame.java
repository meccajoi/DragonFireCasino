package com.github.zipcodewilmington.casino.games.trivia;

import java.util.ArrayList;
import java.util.List;

public class TriviaGame implements GameInterface {
    private List<String> questions = new ArrayList<>();

    @Override
    public void setup() {
        questions = new ArrayList<>();
    }

    @Override
    public void play() {
        System.out.println("Welcome to Trivia!");
        System.out.println("Trivia is not implemented yet. Returning to menu...");
    }

    @Override
    public String getRules() {
        return "Trivia placeholder: welcome message only. Returning to menu.";
    }

    @Override
    public int getMinPlayers() {
        return 1;
    }

    @Override
    public int getMaxPlayers() {
        return 1;
    }
}