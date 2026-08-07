package com.github.zipcodewilmington.casino.games.blackjack;

import com.github.zipcodewilmington.casino.GameInterface;

import java.util.ArrayList;
import java.util.List;

public class BlackjackGame implements GameInterface {
    ////////Fields///////////
    private Dealer dealer = new Dealer();
    private List<BlackjackPlayer> players = new ArrayList<>();
    ////////Fields///////////

    public void addPlayer(BlackjackPlayer player) {
        players.add(player);
    }

    @Override
    public void setup() {
        System.out.println("Setting up Blackjack...");
        dealer.resetHand();
        for (BlackjackPlayer player : players) {
            player.getHand().clear();
        }
    }

    @Override
    public void play() {
        System.out.println("You're in Blackjack!");

        dealer.dealInitialCards(players);

        // Check for dealer blackjack first — if the dealer has 21,
        // the round ends immediately regardless of what players have.
        if (BlackjackScorer.calculateHandValue((dealer.getHand())) == 21) {
            resolveDealerBlackjack();
            return;
        }

        // Player turns — each player hits/stands independently.
        for (BlackjackPlayer player : players) {
            playerTurn(player);
        }

        // Dealer's turn — only draws if at least one player didn't bust,
        // since if everyone busted, there's no reason for the dealer to play on.
        if (anyPlayerStillIn()) {
            dealerTurn();
        }

        resolveOutcomes();
    }

    private void playerTurn(BlackjackPlayer player) {
        // Player blackjack on the deal — automatic win, no turn needed.
        if (BlackjackScorer.calculateHandValue((dealer.getHand())) == 21) {
            System.out.println(player.getName() + " has Blackjack!");
            return;
        }

        while (BlackjackScorer.calculateHandValue((dealer.getHand())) < 21) {
            boolean wantsToHit = player.isBot()
                ? BlackjackScorer.calculateHandValue((dealer.getHand())) < 17
                : askHumanToHit(player);

            if (!wantsToHit) {
                player.stand();
                break;
            }

            player.hit(dealer);
            System.out.println(player.getName() + "'s hand: " + player.getHand()
                + " (value: " + BlackjackScorer.calculateHandValue((dealer.getHand())) + ")");
        }

        if (BlackjackScorer.calculateHandValue((dealer.getHand())) > 21) {
            System.out.println(player.getName() + " busts!");
        }
    }

    /**
     * Placeholder for human input — wiring to actual console/UI input
     * is Casino/MainApplication's responsibility. For now, defaults to
     * the same threshold as bots so the loop is testable standalone.
     */
    private boolean askHumanToHit(BlackjackPlayer player) {
        // TODO: replace with real input once Casino's I/O layer is wired in
        return BlackjackScorer.calculateHandValue((dealer.getHand())) < 17;
    }

    private boolean anyPlayerStillIn() {
        for (BlackjackPlayer player : players) {
            if (BlackjackScorer.calculateHandValue((dealer.getHand())) <= 21) {
                return true;
            }
        }
        return false;
    }

    private void dealerTurn() {
        System.out.println("Dealer's turn...");
        while (dealer.shouldHit()) {
            dealer.hit();
        }
        dealer.revealHand();
    }

    private void resolveDealerBlackjack() {
        dealer.revealHand();
        for (BlackjackPlayer player : players) {
            if (BlackjackScorer.calculateHandValue((dealer.getHand())) == 21) {
                System.out.println(player.getName() + " pushes with the dealer.");
            } else {
                System.out.println(player.getName() + " loses — dealer has Blackjack.");
            }
        }
    }

    private void resolveOutcomes() {
        int dealerValue = BlackjackScorer.calculateHandValue((dealer.getHand()));
        boolean dealerBusted = dealerValue > 21;

        for (BlackjackPlayer player : players) {
            int playerValue = BlackjackScorer.calculateHandValue((dealer.getHand()));

            if (playerValue > 21) {
                System.out.println(player.getName() + " loses — busted.");
            } else if (dealerBusted) {
                System.out.println(player.getName() + " wins — dealer busted.");
            } else if (playerValue > dealerValue) {
                System.out.println(player.getName() + " wins!");
            } else if (playerValue < dealerValue) {
                System.out.println(player.getName() + " loses.");
            } else {
                System.out.println(player.getName() + " pushes.");
            }
        }
    }

    @Override
    public String getRules() {
        return "Blackjack: get as close to 21 as possible without going over. "
             + "Face cards are worth 10, Aces are worth 1 or 11. Dealer hits until 17.";
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