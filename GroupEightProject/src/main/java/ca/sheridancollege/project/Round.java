package ca.sheridancollege.project;

public class Round {
    private HumanPlayer player;
    private Dealer dealer = new Dealer();
    private Deck deck = new Deck();
    private int roundNumber;

    public Round(HumanPlayer player, Dealer dealer, Deck deck) 
    {
        this.player = player;
        this.dealer = dealer;
        this.deck = deck;
    }

    public void startRound() 
    {
        System.out.println("Dealing cards!!");

        player.getHand().addCard(deck.drawCard());
        player.getHand().addCard(deck.drawCard());

        dealer.getHand().addCard(deck.drawCard());
        dealer.getHand().addCard(deck.drawCard());
        Card dealerFirstCard = dealer.getHand().getCards().get(0); // get first card dealer drew
        
        System.out.println("Dealer draws one card face up, " + dealerFirstCard.getValue() + " of " + dealerFirstCard.getSuit());
        System.out.println("Dealer draws one card face down.");
        
        player.playTurn(deck); // needs implementation in player

        // If player hasn't busted, dealer plays
        if (!player.getHand().isBust())
        {
            Card dealerSecondCard = dealer.getHand().getCards().get(1); // get second card dealer drew
            System.out.println("Dealer reveals second card, " + dealerSecondCard.getValue() + " of " + dealerSecondCard.getSuit());
            System.out.println("Dealer Hand Value = " + dealer.hand.getHandValue());
            dealer.playTurn(deck);
        }

        printRoundResult();
        roundNumber++;
    }

    // Get the final scores of player and dealer
    public void printRoundResult() 
    {	
        int playerHandValue = player.getHand().getHandValue();
        int dealerHandValue = dealer.getHand().getHandValue();

        if (player.getHand().isBust())
        {
            System.out.println("Player busts! Dealer wins.");
	}
        else if (dealer.getHand().isBust())
        {
            System.out.println("Dealer busts! Player wins.");
	}
        else if (playerHandValue > dealerHandValue)
        {
            System.out.println("Player wins with " + playerHandValue);
	}
        else if (dealerHandValue > playerHandValue)
        {
            System.out.println("Dealer wins with " + dealerHandValue);
	}
        else
        {
            System.out.println("It's a tie!");
        }
    }
}
