package ca.sheridancollege.project;

import java.util.List;
import java.util.Scanner;

public class Player
{
    private String name;
    private int score;
    private boolean doubleScore = false;
    public Hand hand;

    public Player() 
    {
    	this.hand = new Hand();
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
    
    public boolean getDouble()
    {
        return this.doubleScore;
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
    }

    public void doubleDown(Deck deck) 
    {
        System.out.println(name + " chooses to double down.");
        hit(deck);
        doubleScore = true;
        stand(); // Ends turn
    }

    public void playTurn(Deck deck) // contains the logic for a player - decision tree of choices
    {
        Scanner scanner = new Scanner(System.in);

        while (!hand.isBust())
        {
            System.out.println(name + "'s hand value is " + hand.getHandValue());
            System.out.print(name + ", choose: hit / stand / double: ");
            String action = scanner.nextLine();

            if (action.equals("hit"))
            {
                hit(deck);
            } 
            else if (action.equals("stand"))
            {
                stand();
                break;
            } 
            else if (action.equals("double"))
            {
                doubleDown(deck);
                break; // ends turn after double down
            } 
            else
            {
                System.out.println("Invalid choice.");
            }
        }
    }
}