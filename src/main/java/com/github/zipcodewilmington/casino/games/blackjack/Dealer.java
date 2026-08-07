package com.github.zipcodewilmington.casino.games.blackjack;

import com.github.zipcodewilmington.utils.Card;
import com.github.zipcodewilmington.utils.Deck;
import com.github.zipcodewilmington.utils.Hand;

import java.util.List;

public class Dealer {
    private Hand hand = new Hand();
    private Deck deck = new Deck();

    public void dealInitialCards(List<BlackjackPlayer> players) {
        for (BlackjackPlayer player : players) {
            dealCardTo(player);
            dealCardTo(player);
        }

        //deck.dealCard() runs first which removes a card from the deck and returns the card that was removed. 
        // then that returned removed card is added to the Dealer's hand via the hand.addCard(); signature
        // #methodchanining BB
        hand.addCard(deck.dealCard());
        hand.addCard(deck.dealCard());
    }

    public void dealCardTo(BlackjackPlayer player) {
        Card card = deck.dealCard();
        player.getHand().addCard(card);
    }

    public boolean shouldHit() {
        int value = BlackjackScorer.calculateHandValue(hand);

        if (value < 17) {
            return true;
        }
        if (value == 17 && BlackjackScorer.isSoft(hand)) {
            return true;
        }
        return false;
    }

    public void hit() {
        hand.addCard(deck.dealCard());
    }

    public Hand revealHand() {
        int value = BlackjackScorer.calculateHandValue(hand);
        System.out.println("Dealer's hand: " + hand + " (value: " + value + ")");
        return hand;
    }

    public Hand getHand() {
        return hand;
    }

    public void resetHand() {
        hand.clear();
    }
}