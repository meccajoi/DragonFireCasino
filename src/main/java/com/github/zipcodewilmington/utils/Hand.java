package com.github.zipcodewilmington.utils;

import java.util.ArrayList;
import java.util.List;

public class Hand {

    private List<Card> cards;

    public Hand() {
        cards = new ArrayList<>();
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public List<Card> getCards() {
        return cards;
    }

    public int getTotalValue() {
        int total = 0;
        int numberOfAces = 0;

        for (Card card : cards) {
            total += card.getValue();

            if (card.getRank().equals("Ace")) {
                numberOfAces++;
            }
        }

        while (total > 21 && numberOfAces > 0) {
            total -= 10;
            numberOfAces--;
        }

        return total;
    }

    public void clear() {
        cards.clear();
    }

    @Override
    public String toString() {
        return cards.toString();
    }
}