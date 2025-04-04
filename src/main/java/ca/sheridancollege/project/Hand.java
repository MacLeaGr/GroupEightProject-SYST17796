package ca.sheridancollege.project;

import java.util.List;

public class Hand {
	private List<Card> cards;
        private int handValue = 0;

	public Hand()
        {
            this.cards = cards;
            this.handValue = handValue;
	}

	public List<Card> getCards() // returns what cards are in the hand
        {
		return this.cards;
	}

	public void addCard(Card card) // adds card to hand
        {
            cards.add(card);
	}

	public int getHandValue() // calculates value of cards in hand
        {
            int countValue = 0;
            int numAcesInHand = 0;
            
            for ( int i = 0; i < cards.size() ; i++)
            {
                if (cards.get(i).isAce() == true) // count number of aces to add non bust value after other cards
                {
                   numAcesInHand++; // count aces in hand 
                }
                else
                {
                    countValue = countValue + cards.get(i).getNumValue(); // add value of not aces to hand
                }
            }
            if (countValue + 11 >= 22) // if adding an ace of value 11 == bust, only add aces of value 1
            {
                countValue = countValue + numAcesInHand; // each ace is value 1, so add each ace value once
            }
            else // if adding an ace of value 11 != bust, add one value 11 ace and rest of value 1
            {
                countValue = countValue + numAcesInHand + 10; // each ace is value 1 except one worth 11, so add each ace value once and add 10
            }
            
            return countValue; // return value of all cards in hand
	}

	public boolean isBlackJack() // check for 21, return true or false
        {
            if(handValue == 21)
            {
                return true;
            }
            else
            {
                return false;
            }
	}

	public void clearHand() // empty hand after win or bust
        {
            cards.clear();
	}

	public boolean isBust() // check for greater than 21, return true or false
        {
            if(handValue >= 22)
            {
                return true;
            }
            else
            {
                return false;
            }
	}
}
