package com.github.zipcodewilmington.casino;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.github.zipcodewilmington.casino.games.blackjack.BlackjackGame;
import com.github.zipcodewilmington.casino.games.blackjack.BlackjackPlayer;
import com.github.zipcodewilmington.casino.games.roulette.RouletteGame;
import com.github.zipcodewilmington.casino.games.slots.SlotsGame;
import com.github.zipcodewilmington.casino.games.trivia.TriviaGame;

public class Casino {

    private Scanner scanner = new Scanner(System.in);
    private CasinoAccountManager accountManager = new CasinoAccountManager();
    private CasinoAccount account;

    public void start() {
        System.out.println("=================================");
        System.out.println("   Welcome to DragonFire Casino!");
        System.out.println("=================================");
        System.out.println("Good luck and have fun!");
        System.out.println();
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        account = accountManager.createAccount(name);

        System.out.println("Welcome, " + account.getName() + "!");
        System.out.println("Your starting balance is: $" + account.getBalance());
        System.out.println();

        showMenu();
    }

    public void showMenu() {
        boolean keepPlaying = true;

        while (keepPlaying) {
            System.out.println("Choose a game:");
            System.out.println("1. Blackjack");
            System.out.println("2. Poker");
            System.out.println("3. Roulette");
            System.out.println("4. Slots");
            System.out.println("5. Number Guess");
            System.out.println("6. Trivia");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    BlackjackGame blackjack = new BlackjackGame();
                    blackjack.addPlayer(new BlackjackPlayer("You", false));

                    int numOfPlayers = 0;
                    try {
                        System.out.println("How many players do you want besides yourself?: ");
                        numOfPlayers = scanner.nextInt();
                        scanner.nextLine(); // consume leftover newline

                    } catch (InputMismatchException e) {
                        System.out.println("Invalid character, please try again");
                        scanner.nextLine(); // consume the bad token so it doesn't loop forever
                        numOfPlayers = 1;

                    }
                    

                    for (int i = 0; i < numOfPlayers; i++) {
                        blackjack.addPlayer(new BlackjackPlayer("Bot"+i, true));
                    }

                    playGame(blackjack);

                    break;

                case "2":
                    System.out.println("Poker is coming soon.");
                    break;

                case "3":
                   playGame(new RouletteGame());
                    break;

                case "4":
                    playGame(new SlotsGame());
                    break;

                case "5":
                    System.out.println("Number Guess is coming soon.");
                    break;

                case "6":
                    playGame(new TriviaGame());
                    break;

                case "0":
                    keepPlaying = false;
                    break;

                default:
                    System.out.println("Invalid choice. Enter a number from 0 to 6.");
            }

            System.out.println();
        }

        System.out.println("Thanks for visiting DragonFire Casino!");
    }
    public void playGame(GameInterface game) {
        game.setup();
        game.play();
    }
}