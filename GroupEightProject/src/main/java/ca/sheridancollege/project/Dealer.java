package ca.sheridancollege.project;

public class Dealer extends Player {
    private HouseRules houseRules;

    // Constructor for Dealer
    public Dealer() {
        this.hand = new Hand();  // Initializes the hand
        this.houseRules = new NuclearRules();  
    }

    @Override
    public void playTurn(Deck deck) {
        while (houseRules.shouldHit(this.hand)) {
            this.hand.addCard(deck.drawCard());
            Card nextCard = hand.getCards().get(hand.getCards().size() - 1);
            System.out.println("Dealer hits and draws new card, " + nextCard.getValue() + " of " + nextCard.getSuit());
            System.out.println("Hand Value = " + hand.getHandValue());
        }
    }

    public void revealCard() {
        System.out.println("Dealer reveals: " + this.hand.toString());
    }
}

