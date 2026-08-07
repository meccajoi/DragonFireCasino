package com.github.zipcodewilmington.casino.games.slots;

    import com.github.zipcodewilmington.casino.GameInterface;

    public class SlotsGame implements GameInterface {
    
        private SlotMachine machine = new SlotMachine();

    @Override
    public void setup() {
        System.out.println("Welcome to Slots!");
        System.out.println(getRules());
    }

    @Override
    public void play() {
      int[] reels = machine.spin();

      System.out.println(reels[0] + " | " + reels[1] + " | " + reels[2]);
      System.out.println("Payout: $" + machine.getPayout());
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
