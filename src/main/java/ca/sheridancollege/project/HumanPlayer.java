package ca.sheridancollege.project;

public class HumanPlayer extends Player
{
    private String name;
    private int score;
    public Hand hand;

    public HumanPlayer(String name) 
    {
        this.hand = new Hand();
        this.name = name;
    }
}