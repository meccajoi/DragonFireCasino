package com.github.zipcodewilmington.casino;

/**
 * Created by leon on 7/21/2020.
 * All players of a game should abide by PlayerInterface.
 *
 * A player may be human-controlled or bot-controlled. Balance is not tracked
 * directly by this interface. Instead, the default implementations of
 * deposit() and withdraw() rely on getBalance() and setBalance(), which are
 * implemented by the class using this interface (for example, a CasinoAccount
 * for human players or a simple double field for bots).
 */
public interface PlayerInterface {

    /**
     * @return this player's display name
     */
    String getName();

    /**
     * Places a bet of the given amount.
     *
     * @param amount the amount to wager
     */
    void placeBet(double amount);

    /**
     * @return this player's current balance
     */
    double getBalance();

    /**
     * Sets this player's balance.
     *
     * @param amount the new balance
     */
    void setBalance(double amount);

    /**
     * Adds funds to this player's balance.
     *
     * @param amount the amount to deposit
     */
    default void deposit(double amount) {
        setBalance(getBalance() + amount);
    }

    /**
     * Withdraws funds from this player's balance.
     *
     * @param amount the amount to withdraw
     * @throws InsufficientFundsException if the amount exceeds the current balance
     */
    default void withdraw(double amount) {
        if (amount > getBalance()) {
            throw new InsufficientFundsException(
                "Cannot withdraw " + amount + ": balance is only " + getBalance());
            
        }
        setBalance(getBalance() - amount);
    }

    /**
     * Credits winnings to this player.
     *
     * @param amount the amount won
     */
    void collectWinnings(double amount);
}
