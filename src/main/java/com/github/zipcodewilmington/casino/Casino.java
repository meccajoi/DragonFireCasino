package com.github.zipcodewilmington.casino;

import java.util.List;

/**
 * numBots = 0  -> solo play against the game itself (Slots, NumberGuess, Trivia)
 * numBots > 0  -> human plays alongside bot-controlled opponents (Blackjack, Poker, Roulette)
 */
public class Casino {
    private List<GameInterface> games;
    private CasinoAccountManager accountManager;

    public void start() {
        // TODO
    }

    public void playGame() {
        // TODO
    }

    /**
     * Constructs numBots bot-flagged instances of the matching player class
     * for the given game and runs one round alongside the human player,
     * respecting game.getMinPlayers()/getMaxPlayers().
     */
    public void playGame(GameInterface game, PlayerInterface human, int numBots) {
        // TODO
    }
}
