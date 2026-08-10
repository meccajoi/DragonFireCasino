package com.github.zipcodewilmington.casino.games.roulette;

import java.util.Scanner;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.GameInterface;

public class RouletteGame implements GameInterface {

    private RouletteWheel wheel = new RouletteWheel();
    private Scanner scanner = new Scanner(System.in);
    private CasinoAccount account;

    public RouletteGame(CasinoAccount account) {
        this.account = account;
    }

    @Override
    public void setup() {
        System.out.println("Welcome to Roulette!");
        System.out.println(getRules());
        System.out.println("Current balance: $" + account.getBalance());
    }

    @Override
    public void play() {

        boolean keepPlaying = true;

        while (keepPlaying) {

            System.out.println();
            System.out.println("What would you like to bet on?");
            System.out.println("1. Specific number");
            System.out.println("2. RED");
            System.out.println("3. BLACK");
            System.out.println("4. ODD");
            System.out.println("5. EVEN");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            if (choice < 1 || choice > 5) {
                System.out.println("Invalid choice.");
                continue;
            }

            String playerNumber = "";

            if (choice == 1) {
                System.out.print("Choose 0, 00, or a number from 1 to 36: ");
                playerNumber = scanner.next();
            }

            System.out.print("Enter your bet: $");
            double bet = scanner.nextDouble();

            if (bet <= 0) {
                System.out.println("Bet must be greater than $0.");
                continue;
            }

            if (!account.canAfford(bet)) {
                System.out.println("You do not have enough money.");
                System.out.println("Current balance: $" + account.getBalance());
                continue;
            }

            account.withdraw(bet);

            String result = wheel.spin();
            String resultColor = wheel.getColor(result);

            System.out.println();
            System.out.println("The wheel is spinning...");
            System.out.println("The ball landed on: " + resultColor + " " + result);

            boolean won = false;

            if (choice == 1) {
                won = playerNumber.equals(result);
            }

            if (choice == 2) {
                won = resultColor.equals("RED");
            }

            if (choice == 3) {
                won = resultColor.equals("BLACK");
            }

            if (!result.equals("0") && !result.equals("00")) {

                int number = Integer.parseInt(result);

                if (choice == 4) {
                    won = number % 2 != 0;
                }

                if (choice == 5) {
                    won = number % 2 == 0;
                }
            }

            if (won) {

                if (choice == 1) {

                    double payout = bet * 36;
                    double profit = bet * 35;

                    account.deposit(payout);

                    System.out.println("You win!");
                    System.out.println("You won $" + profit);

                } else {

                    double payout = bet * 2;

                    account.deposit(payout);

                    System.out.println("You win!");
                    System.out.println("You won $" + bet);
                }

            } else {

                System.out.println("You lose!");
                System.out.println("You lost $" + bet);
            }

            System.out.println("Current balance: $" + account.getBalance());

            if (account.getBalance() <= 0) {

                System.out.println("You are out of money.");
                keepPlaying = false;

            } else {

                System.out.println();
                System.out.print("Would you like to play Roulette again? yes/no: ");

                String answer = scanner.next();

                if (answer.equalsIgnoreCase("yes")
                        || answer.equalsIgnoreCase("y")) {

                    System.out.println();
                    System.out.println("Current balance: $" + account.getBalance());

                } else {

                    keepPlaying = false;
                    System.out.println("Returning to the casino menu...");
                }
            }

        }
    }

    @Override
    public String getRules() {
        return "Bet on a specific number, RED, BLACK, ODD, or EVEN. "
                + "The wheel has 0, 00, and numbers 1 through 36. "
                + "0 and 00 are GREEN and do not count as odd or even.";
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