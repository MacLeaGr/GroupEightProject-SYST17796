public class Round {
    private HumanPlayer player;
    private Dealer dealer;
    private Deck deck;
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
        
        player.playTurn(deck);

        // If player hasn't busted, dealer plays
        if (!player.getHand().isBust())
        {
            dealer.playTurn();
        }

        printResult();
    }

    // Get the final scores of player and dealer
    public void printResult() 
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
