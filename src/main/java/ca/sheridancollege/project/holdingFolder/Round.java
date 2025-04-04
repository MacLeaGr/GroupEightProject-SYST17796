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
        int playerScore = player.getHand().getScore();
        int dealerScore = dealer.getHand().getScore();

        if (player.getHand().isBust())
        {
            System.out.println("Player busts! Dealer wins.");
	}
        else if (dealer.getHand().isBust())
        {
            System.out.println("Dealer busts! Player wins.");
	}
        else if (playerScore > dealerScore)
        {
            System.out.println("Player wins with " + playerScore);
	}
        else if (dealerScore > playerScore)
        {
            System.out.println("Dealer wins with " + dealerScore);
	}
        else
        {
            System.out.println("It's a tie!");
        }
    }




}
