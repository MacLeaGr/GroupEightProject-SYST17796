package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.List;

public class Game{
    private HumanPlayer player;
    private Deck deck;
    private Dealer dealer;
    private List<Round> rounds;


    public Game(HumanPlayer player) 
    {
        this.player = player;
        this.dealer = new Dealer();
        this.deck = new Deck();
        this.rounds = new ArrayList<>();
    }
	
    public void startGame()
    {
        System.out.println("Starting The Game!!");
        deck.resetDeck();
    }
    
    public void playRound() // initiates round for user to play
    {
        Round round = new Round(player, dealer, deck);
    	rounds.add(round);
    	round.startRound();
    }

    public void resetGame() // clears deck and number of rounds for next game
    {
        deck.resetDeck();
        rounds.clear();
    }

    public void printScore() // prints at end of round to show card values to player
    {
        System.out.println(player.getName() + " has: " + player.hand.getHandValue());
        System.out.println("Dealer has: " + dealer.hand.getHandValue());
    }
}
