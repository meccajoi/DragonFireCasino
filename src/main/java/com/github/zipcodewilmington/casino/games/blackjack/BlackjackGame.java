package com.github.zipcodewilmington.casino.games.blackjack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.github.zipcodewilmington.casino.GameInterface;

public class BlackjackGame implements GameInterface {
    ////////Fields///////////
    private Dealer dealer = new Dealer();
    private List<BlackjackPlayer> players = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);
    private Map<BlackjackPlayer, Double> currentBets = new HashMap<>();
 
    ////////Fields///////////

    public void addPlayer(BlackjackPlayer player) {
        players.add(player);
    }

    //SETUP METHOD
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
        //Money Stuff:
        System.out.println("Welcome to Blackjack!");
        System.out.println("Your table limit is: " + getMaxPlayers());

        for (BlackjackPlayer player : players) {
            if (!player.isBot()) {
                if (player.getBalance() <= 0) {
                    System.out.println(player.getName() + ", you're out of money and can't play this round.");
                    return;
                }

            double bet = -1;
            while (bet <= 0 || bet > player.getBalance()) {
                System.out.println(player.getName() + ", your balance is: $" + player.getBalance());
                System.out.print("Enter your bet: ");
                try {
                    bet = Double.parseDouble(scanner.nextLine());
                    if (bet <= 0) {
                        System.out.println("Bet must be greater than $0.");
                    } else if (bet > player.getBalance()) {
                        System.out.println("You can't bet more than your balance.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid amount, try again.");
                    bet = -1;
                }
            }
                player.placeBet(bet);
                currentBets.put(player, bet);
            } else {
                double botBet = 10.0;
                player.placeBet(botBet);
                currentBets.put(player, botBet);
            }
}
        //close money stuff

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
    }//end play()

    private void playerTurn(BlackjackPlayer player) {
        if (BlackjackScorer.calculateHandValue((player.getHand())) == 21) {
            System.out.println(player.getName() + " has Blackjack!");
            return;
        }

        System.out.println(player.getName() + "'s hand: " + player.getHand() + " (value: " + BlackjackScorer.calculateHandValue((player.getHand())) + ")" );


//Player options
        boolean turnOver = false;

            while (!turnOver && BlackjackScorer.calculateHandValue((player.getHand())) < 21) {
            if (player.isBot()) {

                //Bot's are gonna hit as long as their hand is less than 17.
                if (BlackjackScorer.calculateHandValue((player.getHand())) < 17) {
                    player.hit(dealer);
                    System.out.println(player.getName() + "'s hand: " + player.getHand()
                        + " (value: " + BlackjackScorer.calculateHandValue((player.getHand())) + ")");
                } else {
                    //If the hand is over 17 then the bot will stand, aka they will stop drawing cards
                    player.stand();
                    turnOver = true;
                }
                continue;
            }
    
            System.out.println("How do you want to play? :");
            System.out.println("1. HIT");
            System.out.println("2. STNAD/STAY");
            System.out.println("3. DOUBLE DOWN");
            System.out.println("4. SPLIT");
            System.out.print("Enter your choice: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1" : player.hit(dealer);
                System.out.println(player.getName() + "'s hand: " + player.getHand()
                    + " (value: " + BlackjackScorer.calculateHandValue((player.getHand())) + ")");
                break;
                case "2" : player.stand();
                // System.out.println(player.getName() + " stands.");
                turnOver = true;
                break;
                case "3":
                    double additionalBet = currentBets.get(player);
                    player.doubleDown(dealer, additionalBet);
                    currentBets.put(player, currentBets.get(player) * 2); // update tracked bet to reflect the double
                    turnOver = true;// double down = exactly one card, then done
                    break;
                // case "4" : player.split(dealer);
                // break;
                default: System.out.println("Invalide choice, try again.");
            }
        

        if (BlackjackScorer.calculateHandValue((player.getHand())) > 21) {
            System.out.println(player.getName() + " busts!");
        }
    }
}

    private boolean anyPlayerStillIn() {
        for (BlackjackPlayer player : players) {
            if (BlackjackScorer.calculateHandValue((player.getHand())) <= 21) {
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
        if (BlackjackScorer.calculateHandValue((player.getHand())) == 21) {
            player.collectWinnings(currentBets.get(player));
            System.out.println(player.getName() + " pushes with the dealer.");
        } else {
            System.out.println(player.getName() + " loses - dealer has Blackjack.");
        }
    }
}


    ///////////review
   private void resolveOutcomes() {
    int dealerValue = BlackjackScorer.calculateHandValue((dealer.getHand()));
    boolean dealerBusted = dealerValue > 21;

    for (BlackjackPlayer player : players) {
        int playerValue = BlackjackScorer.calculateHandValue((player.getHand()));

        if (playerValue > 21) {
            System.out.println(player.getName() + " loses - busted.");
        } else if (dealerBusted || playerValue > dealerValue) {
            double winnings = currentBets.get(player) * 2;
            player.collectWinnings(winnings);
            if (dealerBusted) {
                System.out.println(player.getName() + " wins - dealer busted.");
            } else {
                System.out.println(player.getName() + " wins!");
            }
        } else if (playerValue < dealerValue) {
            System.out.println(player.getName() + " loses.");
        } else {
            player.collectWinnings(currentBets.get(player));
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
        return 7;
    }
}
