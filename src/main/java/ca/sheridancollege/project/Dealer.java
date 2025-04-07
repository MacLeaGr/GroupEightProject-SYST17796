package ca.sheridancollege.project;

import java.util.Scanner;

public class Dealer extends Player
{
    private HouseRules houseRules;

    // Constructor for Dealer
    public Dealer()
    {
        this.hand = new Hand();  // Initializes the hand
        this.houseRules = new NuclearRules();  // Default rules, can be changed later
    }

    // Method to set the rules dynamically
    public void setHouseRules(int ruleChoice)
    {
        switch (ruleChoice)
        {
            case 1 ->
            {
                this.houseRules = new NuclearRules();  // Dealer hits on soft 17
                System.out.println("Dealer follows Nuclear Rules (hits on soft 17).");
            }
            case 2 ->
            {
                this.houseRules = new DynamiteRules();  // Dealer hits on 15, stands on 16
                System.out.println("Dealer follows Dynamite Rules (hits on 15, stands on 16).");
            }
            case 3 ->
            {
                this.houseRules = new HologramRules();  // Dealer draws on 16, stands on 17
                System.out.println("Dealer follows Hologram Rules (draws on 16, stands on 17).");
            }
            default ->
            {
                System.out.println("Invalid choice, using default Nuclear Rules.");
                this.houseRules = new NuclearRules();  // Default to Nuclear Rules
            }
        }
    }

    @Override
    public void playTurn(Deck deck)
    {
        // The dealer plays according to the chosen rules
        while (houseRules.shouldHit(this.hand))
        {
            this.hand.addCard(deck.drawCard());
            Card nextCard = hand.getCards().get(hand.getCards().size() - 1);
            System.out.println("Dealer hits and draws new card, " + nextCard.getValue() + " of " + nextCard.getSuit());
            System.out.println("Dealer Hand Value = " + hand.getHandValue());
            
            if (hand.getHandValue() > 21)
            {
                System.out.println("Dealer busts with hand value: " + hand.getHandValue());
                break;
            }
        }
    }

    public void revealCard()
    {
        System.out.println("Dealer reveals: " + this.hand.toString());
    }
}
