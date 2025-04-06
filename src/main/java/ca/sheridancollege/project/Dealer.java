package ca.sheridancollege.project;

import java.util.Scanner;

public class Dealer extends Player {
	private HouseRules houseRules;

    // Constructor for Dealer
    public Dealer() {
        this.hand = new Hand();  // Initializes the hand
        this.houseRules = chooseRules();  // Set the rules based on user input
    }

    // Method to choose the game rules
    protected HouseRules chooseRules() {
        Scanner scanner = new Scanner(System.in);

        // Let the user choose the ruleset
        System.out.println("Choose the game rules: ");
        System.out.println("1. Nuclear Rules (Dealer hits on soft 17)");
        System.out.println("2. Dynamite Rules (Dealer hits on 15, stands on 16)");
        System.out.println("3. Hologram Rules (Dealer hits on 16, stands on 17)");
        
        int choice = scanner.nextInt();
        
        // Return the correct HouseRules subclass based on user input
        switch (choice) {
            case 1 -> {
                return new NuclearRules();
                }
            case 2 -> {
                return new DynamiteRules();
                }
            case 3 -> {
                return new HologramRules();
                }
            default -> {
                System.out.println("Invalid choice. Defaulting to Nuclear Rules.");
                return new NuclearRules();  // Defaults to NuclearRules if invalid input
                }
        }
    }
        @Override
	public void playTurn(Deck deck) {
		while (houseRules.shouldHit(this.hand)) {
                this.hand.addCard(deck.drawCard());
        }
	}

	public void revealCard() {
		 System.out.println("Dealer reveals: " + this.hand.toString());
	}
}

