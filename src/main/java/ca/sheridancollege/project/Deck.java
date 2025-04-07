package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.List;

public class Deck
{
    private List<Card> cards; // list of drawn cards
        
    public Deck()
    {
        this.cards = new ArrayList<>();
    }

    public Card drawCard() // called to generate a new card and validate that it has not already been drawn
    {   
        Card newCard = null; // empty card is prepared to be overwritten by loop
        boolean duplicate = true; // duplicate is pre-set to true to start while loop
        
        do
        {
            newCard = new Card(); // new card assigned to empty / duplicate variable
            duplicate = false; // set to false to overwrite if a duplicate is found
            
            for(int i = 0; i < cards.size() ; i++)
            {
                if (cards.get(i).getSuit().equals(newCard.getSuit()) && cards.get(i).getValue().equals(newCard.getValue()))
                {
                    duplicate = true; // if a card in the drawn list is the same as the new card, the loop repeats
                    break;
                }
            }
        } while(duplicate);
            
        cards.add(newCard); // non-duplicate card is added to drawn cards list
        return newCard;
    }

    public void resetDeck() // in blackjack, shuffling and resetting the deck are functionally the same as a shuffle only happens at the end of a round,
    {                       // therefore, shuffle has been removed
        cards.clear();
    }
}
