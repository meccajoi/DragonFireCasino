package com.github.zipcodewilmington.casino;

/**
 * Created by leon on 7/21/2020.
 * All games offered by the casino must abide by GameInterface.
 */
public interface GameInterface {

    /**
     * Prepares the game to be played by initializing any game-specific state
     * (e.g. shuffling a deck, resetting a secret number) before play() is called.
     */
    void setup();

    /**
     * Runs one full round of the game.
     * Must be implemented by every game since play logic is different for each game.
     */
    void play();

    /**
     * @return a human-readable description of how this game is played
     */
    String getRules();

    /**
     * @return the minimum number of players required to start this game
     */
    int getMinPlayers();

    /**
     * @return the maximum number of players this game supports
     */
    int getMaxPlayers();
}