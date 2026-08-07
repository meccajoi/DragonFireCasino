package com.github.zipcodewilmington.casino.games.blackjack;

import com.github.zipcodewilmington.utils.Card;
import com.github.zipcodewilmington.utils.Hand;

/**
 * Shared blackjack scoring logic. Hand itself stays game-agnostic
 * (shared with Poker), so this class holds the blackjack-specific
 * total/ace-adjustment math instead. Both Dealer and BlackjackPlayer
 * call into this rather than duplicating the logic.
 */
public class BlackjackScorer {

    private BlackjackScorer() {
        // utility class — not meant to be instantiated
    }

    /**
     * Total value of a hand under blackjack rules. Aces count as 11
     * unless that would bust the hand, in which case they're downgraded
     * to 1 one at a time until the total is 21 or under (or no aces remain).
     */
    public static int calculateHandValue(Hand hand) {
        int total = 0;
        int numberOfAces = 0;

        for (Card card : hand.getCards()) {
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

    /**
     * True if the hand contains an Ace currently being counted as 11
     * to reach its current total — i.e. the hand has "give" left in it.
     * Independent from calculateHandValue()'s final total, since that
     * method only reports the end result, not whether an Ace survived as 11.
     */
    public static boolean isSoft(Hand hand) {
        int totalWithAcesLow = 0;
        boolean hasAce = false;

        for (Card card : hand.getCards()) {
            if (card.getRank().equals("Ace")) {
                hasAce = true;
                totalWithAcesLow += 1;
            } else {
                totalWithAcesLow += card.getValue();
            }
        }

        int actualValue = calculateHandValue(hand);
        return hasAce && totalWithAcesLow < actualValue;
    }
}