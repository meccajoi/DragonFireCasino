package com.github.zipcodewilmington.casino;

import java.util.Scanner;

public class Casino {

    private Scanner scanner = new Scanner(System.in);

    public void start() {
        System.out.println("=================================");
        System.out.println("   Welcome to DragonFire Casino!");
        System.out.println("=================================");
        System.out.println("Good luck and have fun!");
        System.out.println();

        playGame();
    }

    public void playGame() {
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
                    System.out.println("Blackjack is coming soon.");
                    break;

                case "2":
                    System.out.println("Poker is coming soon.");
                    break;

                case "3":
                    System.out.println("Roulette is coming soon.");
                    break;

                case "4":
                    System.out.println("Slots are coming soon.");
                    break;

                case "5":
                    System.out.println("Number Guess is coming soon.");
                    break;

                case "6":
                    System.out.println("Trivia is coming soon.");
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
}