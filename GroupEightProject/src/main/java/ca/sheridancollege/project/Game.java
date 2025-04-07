package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.List;

public class Game
{
    private HumanPlayer player;
    private Deck deck;
    private Dealer dealer;
    private List<Round> rounds;

    public Game(HumanPlayer player, Dealer dealer) 
    {
        this.player = player;
        this.dealer = dealer;
        this.deck = new Deck();
        this.rounds = new ArrayList<>();
    }
	
    public void startGame()
    {
        System.out.println("Starting The Game!!");
        resetGame();
    }
    
    public void playRound() // initiates round for user to play
    {
        Round round = new Round(player, dealer, deck);
    	rounds.add(round);
    	round.startRound();
        player.setScore(player.getScore() + round.getNumWins());
    }

    public void resetGame() // clears deck and number of rounds for next game
    {
        deck.resetDeck();
        rounds.clear();
        player.hand.clearHand();
        dealer.hand.clearHand();
    }
}
