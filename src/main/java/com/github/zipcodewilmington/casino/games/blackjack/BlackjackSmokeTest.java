package com.github.zipcodewilmington.casino.games.blackjack;

public class BlackjackSmokeTest {
    public static void main(String[] args) {
        BlackjackGame game = new BlackjackGame();

        BlackjackPlayer human = new BlackjackPlayer("You", false);
        BlackjackPlayer bot = new BlackjackPlayer("Bot", true);

        game.addPlayer(human);
        game.addPlayer(bot);

        game.setup();
        game.play();
    }
}