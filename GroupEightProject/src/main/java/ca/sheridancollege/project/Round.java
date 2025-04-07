package ca.sheridancollege.project;

public class Round
{
    private HumanPlayer player;
    private Dealer dealer = new Dealer();
    private Deck deck = new Deck();
    private int numWins = 0;
    private int doubleScore = 0;

    public Round(HumanPlayer player, Dealer dealer, Deck deck) 
    {
        this.player = player;
        this.dealer = dealer;
        this.deck = deck;
    }

    public void startRound() 
    {
        // Clear the previous round's hands
        player.getHand().clearHand();
        dealer.getHand().clearHand();
        
        System.out.println("Dealing cards!!");

        player.getHand().addCard(deck.drawCard());
        player.getHand().addCard(deck.drawCard());
        Card pFC = player.getHand().getCards().get(0); // get player first card
        Card pSC = player.getHand().getCards().get(1); // get player second card
                
        System.out.println(player.getName() + " is dealt two cards, " + pFC.getValue() + " of " + pFC.getSuit() + ", and " + pSC.getValue() + " of " + pSC.getSuit() );
        
        dealer.getHand().addCard(deck.drawCard());
        dealer.getHand().addCard(deck.drawCard());
        Card dFC = dealer.getHand().getCards().get(0); // get dealer first card
        
        Card dSC = dealer.getHand().getCards().get(1); // get dealer second card, added at professor's request
        
        System.out.println("Dealer draws one card face up, " + dFC.getValue() + " of " + dFC.getSuit());
        // System.out.println("Dealer draws one card face down."); // regular code
        System.out.println("Dealer draws one card face down."+ dSC.getValue() + " of " + dSC.getSuit()); // dealer card is revealed on professor's request
        
        player.playTurn(deck);

        // If player hasn't busted, dealer plays
        if (!player.getHand().isBust())
        {
            // Card dSC = dealer.getHand().getCards().get(1); replaced with overwrite at professor's request
            dSC = dealer.getHand().getCards().get(1); // get dealer second card
            System.out.println("Dealer reveals second card, " + dSC.getValue() + " of " + dSC.getSuit());
            System.out.println("Dealer Hand Value = " + dealer.hand.getHandValue());
            dealer.playTurn(deck);
        }
        printRoundResult();
    }

    // Get the final scores of player and dealer
    public void printRoundResult() 
    {	
        int playerHandValue = player.getHand().getHandValue();
        int dealerHandValue = dealer.getHand().getHandValue();
        if(player.getDouble()) // if player doubled down returns true
        {
            doubleScore = 2;
        }
        else
        {
            doubleScore = 1;
        }

        if (player.getHand().isBust())
        {
            System.out.println("Player busts! Dealer wins with " + dealerHandValue);
	}
        else if (dealer.getHand().isBust())
        {
            System.out.println("Dealer busts! Player wins with " + playerHandValue);
            numWins += doubleScore; // if player wins, doubleScore is added
	}
        else if (playerHandValue > dealerHandValue)
        {
            System.out.println("Player wins with " + playerHandValue);
            numWins += doubleScore; // if player wins, doubleScore is added
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
    
    public int getNumWins()
    {
        return this.numWins;
    }
}
