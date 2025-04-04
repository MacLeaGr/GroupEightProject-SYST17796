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
    
    public void playRound() 
    {
        Round round = new Round(player, dealer, deck);
    	rounds.add(round);
    	round.startRound();
    }

    public void resetGame() 
    {
        deck.resetDeck();
        rounds.clear();
    }
    
    public void addPlayer(HumanPlayer player) 
    {
        this.player = player;
    }

    public void printScore()
    {
        System.out.println(player.getName() + " has: " + player.getScore());
        System.out.println("Dealer has: " + dealer.getScore());
    }
}
