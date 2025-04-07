package ca.sheridancollege.project;

public class Card {
	private String suit;
	private String value; // face value ("ACE, FIVE, KING etc.)
        private int numValue; // number value ("6, 2, 10 etc.)
        private boolean ace;
        
        private enum Suit {CLUBS, DIAMONDS, HEARTS, SPADES}; // enum for all possible suits
        public enum Value {ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING}; // enum for all possible card values

	public Card()
        {
            int suitNum = (int)(Math.random() * 4); // generate random number between 0 - 3
            this.suit = setSuit(suitNum); // set card suit to randomly generated suit
            
            int valueNum = (int)(Math.random() * 13); // generate random number between 0 - 12
            this.value = setValue(valueNum); // set card value to randomly generated value
            
            switch(value) // switch statement to assign a integer value to each card generated
            {
                case "ACE":
                    this.numValue = 0; // aces value assigned per ace in hand later
                    break;
                case "TWO":
                    this.numValue = 2;
                    break;
                case "THREE":
                    this.numValue = 3;
                    break;
                case "FOUR":
                    this.numValue = 4;
                    break;
                case "FIVE":
                    this.numValue = 5;
                    break;
                case "SIX":
                    this.numValue = 6;
                    break;
                case "SEVEN":
                    this.numValue = 7;
                    break;
                case "EIGHT":
                    this.numValue = 8;
                    break;
                case "NINE":
                    this.numValue = 9;
                    break;
                case "TEN":     // TEN - KING will all have a value of 10, so that is reflected here
                case "JACK":
                case "QUEEN":
                case "KING":
                    this.numValue = 10;
                    break;
            }
            
            this.ace = "ACE".equals(this.value); // set boolen "ace" to true or false
	}

	public String getSuit()
        {
            return this.suit;
	}
        
        private String setSuit(int num) // assign suit to blank card
        {
           Suit suit = Suit.values()[num];
           return suit.toString();
        }
        
	public String getValue()
        {
            return this.value;
	}
        
        private String setValue(int num) // assign value to blank card
        {
            Value value = Value.values()[num];
            return value.toString();
        }
        
        public int getNumValue()
        {
            return this.numValue;
        }
        
	public boolean isAce()
        {
            return this.ace;
	}
}
