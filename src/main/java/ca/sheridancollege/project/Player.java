package ca.sheridancollege.project;

import ca.sheridancollege.project.Hand;
import java.util.List;

public class Player {
	private String name;
	private int score;
	private Hand hand;
        private Hand splitHand;

	public String getName() // user is shown player name
        {
            return this.name;
	}
        
        public void setName() // user enters new name
        {
            // user inputs name
            // program checks if name is new, if not, prompts again for new name
            
            // score set to 0
            this.score = 0;
        }
        
        public Hand getHand() // user is shown player hand
        {
            return this.hand;
        }

	public void stand() // user does not take any action, ends turn
        {
            throw new UnsupportedOperationException();
	}

	public void hit() // user adds card to hand, auto checks for bust
        {
            throw new UnsupportedOperationException();
	}

	public void doubleDown() // user hits and earns 2x points if wins
        {
            throw new UnsupportedOperationException();
	}

	public void playTurn() // not sure what this should do
        {
            throw new UnsupportedOperationException();
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
