package com.github.zipcodewilmington.casino.games.slots;

import java.util.Scanner;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.GameInterface;

public class SlotsGame implements GameInterface {

    private SlotMachine machine = new SlotMachine();
    private CasinoAccount account;
    private Scanner scanner = new Scanner(System.in);

    public SlotsGame(CasinoAccount account) {
        this.account = account;
    }

    @Override
    public void setup() {
        System.out.println( "Welcome to Slots! 🎰");
        System.out.println(getRules());
    }

    @Override
    public void play() {

    boolean keepPlaying = true;

    while (keepPlaying) {

        machine.spin();

        int[] reels = machine.getReels();

        System.out.println();
        System.out.println(
        getEmoji(reels[0]) + " | " +
        getEmoji(reels[1]) + " | " +
        getEmoji(reels[2]));

        double payout = machine.getPayout();

        if (payout > 0) {
                account.deposit(payout);
            System.out.println("🎉 You won $" + payout + "!");
        } else {
                System.out.println("😢 No win this time.");
        }

        System.out.println("Current balance: $" + account.getBalance());

        System.out.print("Do you want to continue? (yes/no): ");
        String answer = scanner.nextLine();

        if (answer.equalsIgnoreCase("no") || answer.equalsIgnoreCase("n")) {
        keepPlaying = false;
        } else if (answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("y")) {
    keepPlaying = true;
        }
    }
}
    private String getEmoji(int number) {

        switch (number) {
            case 1:
                return "🍒";
            case 2:
                return "🍓";
            case 3:
                return "🍋";
            case 4:
                return "🐉";
            case 5:
                return "🔥";
            case 6:
                return "💎";
            default:
                return "❓";
        }
    }

    @Override
    public String getRules() {
        return "Match all 3 reels to win 100. Match 2 reels to win 20.";
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