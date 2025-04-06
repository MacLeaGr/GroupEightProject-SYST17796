package ca.sheridancollege.project;


import ca.sheridancollege.project.Hand;
import java.util.List;
import java.util.Scanner;

public class Player {
	private String name;
	private int score;
	public Hand hand;
        public Hand splitHand;

	public Player() 
	{
    		this.hand = new Hand();
    		this.splitHand = new Hand();
        }


	public String getName() // user is shown player name
        {
            return this.name;
	}
        
        public void setName(String name) // user enters new name
        {
            this.name = name;
        }
        
        public int getScore()
        {
            return this.score;
        }      
        public void setScore(int score)
        {
            this.score = score;
        }
        
        public Hand getHand() // user is shown player hand
        {
            return this.hand;
        }

	public void stand() // user does not take any action, ends turn
        {
           System.out.println(name + " stands.");
	}

	public void hit(Deck deck) // user adds card to hand, auto checks for bust
        {
           Card newCard = deck.drawCard();
   	   hand.addCard(newCard);
		
           System.out.println(name + " hits, new card: " + newCard.getValue() + " of " + newCard.getSuit());
           System.out.println("Hand value is now: " + hand.getHandValue());

    		if (hand.isBust()) 
		{
        	System.out.println(name + " busts!");
		}
	}

	public void doubleDown(Deck deck) 
        {
           System.out.println(name + " chooses to double down.");
    	   hit(deck);
           stand(); // Ends turn
	}

	public void playTurn(Deck deck) // contains the logic for a player - decision tree of choices
        {
              Scanner scanner = new Scanner(System.in);

    		while (!hand.isBust())
              {
        	   System.out.print(name + ", choose: hit / stand / double: ");
                   String action = scanner.nextLine();

                   if (action.equals("hit")) {
                     hit(deck);
                  
		   } else if (action.equals("stand")) {
                   stand();
                   break;
                   
		   } else if (action.equals("double")) {
                   doubleDown(deck);
                   break; // ends turn after double down
                  
		   } else {
                   System.out.println("Invalid choice.");
                   }
              }
	}

	public void split() // user splits into two hands, may play again on both
        {
             List<Card> cards = hand.getCards(); // list of drawn cards
            boolean canSplit = false; // set false as default
            
            // search hand for duplicate card VALUES ("TEN", "ACE" etc.)
            String splitValue = cards.getLast().getValue(); // get the value ("TEN", "SEVEN" etc) of last card drawn
            for ( int i = 0; i < (cards.size() - 1) ; i++) // for as many cards in hand - 1
            {
                if (cards.get(i).getValue().equals(splitValue)) // if two of same card String Value == true;
                {
                    canSplit = true; // if two cards are the same, user can split
                    splitHand.addCard(hand.removeCard(i)); // remove card from base hand, add to split hand
                }
            }
            if (canSplit == true)
            {
                System.out.println("Player has Split");
            }
            else
            {
                System.out.println("Player cannot Split");
            }
	}
}
