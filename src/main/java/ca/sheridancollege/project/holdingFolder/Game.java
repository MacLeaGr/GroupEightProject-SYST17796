import java.util.ArrayList;
import java.util.List;

public class Game{
    private HumanPlayer player;
    private Deck deck;
    private Dealer dealer;
    private List<Round> rounds;


    public Game(Dealer dealer, HumanPlayer player) 
    {
        this.dealer = dealer;
        this.player = player;
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
    
    public void addPlayer(HumanPlayer player) // imports player data to game class
    {
        this.player = player;
    }

    public void printScore() // prints at end of round to show card values to player
    {
        System.out.println(player.getName() + " has: " + player.getHandValue());
        System.out.println("Dealer has: " + dealer.getHandValue());
    }
}
