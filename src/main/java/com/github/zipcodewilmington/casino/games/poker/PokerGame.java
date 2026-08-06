package com.github.zipcodewilmington.casino.games.poker;

import java.util.ArrayList;
import java.util.List;
import com.github.zipcodewilmington.casino.GameInterface;

public class PokerGame implements GameInterface {
    private Deck deck;
    private List<Card> communityCards = new ArrayList<>();

    @Override
    public void setup() {
        // TODO
    }

    @Override
    public void play() {
        // TODO
    }

    @Override
    public String getRules() {
        // TODO
        return null;
    }

    @Override
    public int getMinPlayers() {
        // TODO
        return 1;
    }

    @Override
    public int getMaxPlayers() {
        // TODO
        return 1;
    }
}
