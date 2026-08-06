package com.github.zipcodewilmington.casino.games.blackjack;

import com.github.zipcodewilmington.utils.Deck;
import com.github.zipcodewilmington.utils.Hand;

/**
 * Not a PlayerInterface implementer — no betting, no balance.
 * Owns the shared shoe for Blackjack.
 */
public class Dealer {
    private Hand hand = new Hand();
    private Deck deck;

    public void dealInitialCards() {
        // TODO
    }

    public void hitOnSoft17() {
        // TODO
    }

    public void revealHand() {
        // TODO
    }
}
