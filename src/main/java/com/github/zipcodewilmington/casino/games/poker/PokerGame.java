package com.github.zipcodewilmington.casino.games.poker;

import java.util.ArrayList;
import java.util.List;
import com.github.zipcodewilmington.casino.GameInterface;

public class PokerGame implements GameInterface {
    private Deck deck;
    private List<Card> communityCards = new ArrayList<>();

    @Override
    public void setup() {
        deck = new Deck();
        communityCards = new ArrayList<>();
    }

    @Override
    public void play() {
        System.out.println("Welcome to Texas Hold'em!");
        System.out.println("Poker is not implemented yet. Returning to menu...");
    }

    @Override
    public String getRules() {
        return "Poker placeholder: welcome message only. Returning to menu.";
    }

    @Override
    public int getMinPlayers() {
        return 2;
    }

    @Override
    public int getMaxPlayers() {
        return 10;
    }
}