package ca.sheridancollege.project;

import ca.sheridancollege.project.Hand;

public class Player {
	private String name;
	private int score;
	private Hand hand;

	public String getName()
        {
		return this.name;
	}
        
        public void setName()
        {
            // user inputs name
            
        }

	public int getHandValue()
        {
            return this.score;
	}
        
        public void setHandValue
        {
            
        }

	public void stand()
        {
		throw new UnsupportedOperationException();
	}

	public void hit()
        {
            player.getHand().addCard(deck.drawCard());
	}

	public void doubleDown()
        {
		throw new UnsupportedOperationException();
	}

	public void playTurn()
        {
		throw new UnsupportedOperationException();
	}

	public void split()
        {
		throw new UnsupportedOperationException();
	}
}
