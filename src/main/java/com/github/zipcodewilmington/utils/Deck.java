package com.github.zipcodewilmington.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {

    private List<Card> cards;

    public Deck() {
        cards = new ArrayList<>();
        createDeck();
    }

    private void createDeck() {
        String[] suits = {
            "Hearts",
            "Diamonds",
            "Clubs",
            "Spades"
        };

        String[] ranks = {
            "2", "3", "4", "5", "6", "7", "8", "9", "10",
            "Jack", "Queen", "King", "Ace"
        };

        for (String suit : suits) {
            for (String rank : ranks) {
                int value;

                if (rank.equals("Jack")
                        || rank.equals("Queen")
                        || rank.equals("King")) {

                    value = 10;

                } else if (rank.equals("Ace")) {

                    value = 11;

                } else {

                    value = Integer.parseInt(rank);
                }

                cards.add(new Card(rank, suit, value));
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public Card dealCard() {
        if (cards.isEmpty()) {
            throw new IllegalStateException("There are no cards left in the deck.");
        }

        return cards.remove(0);
    }

    public int getNumberOfCards() {
        return cards.size();
    }
}