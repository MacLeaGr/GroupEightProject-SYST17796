package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.List;

public class Hand {
    
    private List<Card> cards;

    public Hand() {
        this.cards = new ArrayList<>();
    }

    public List<Card> getCards() {
        return this.cards;
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public Card removeCard(int location) {
        Card tempCard = cards.get(location);
        cards.remove(location);
        return tempCard;
    }

    public int getHandValue() {
            
         int total = 0;
        int aceCount = 0;
        
            for (Card card : cards)
            {
                total += card.getNumValue();
                if (card.isAce())
                { // Check if card is an Ace
                    aceCount++; // Keep track of aces in hand
                }
            }
             // Handle Aces: If the total is <= 11, count an Ace as 11 (else count it as 1)
    for (int i = 0; i < aceCount; i++) {
        if (total <= 11) {
            total += 10;  // Add 10 for Ace if total <= 11 (Ace can be counted as 11)
        }
    }

    return total;

        }
        
    public boolean isBlackJack() { // check for 21, return true or false
        
        if(getHandValue() == 21)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public boolean isBust() // check for greater than 21, return true or false
    {
        if(getHandValue() >= 22)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public void clearHand() {
        cards.clear();
    }
}
