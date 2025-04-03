package ca.sheridancollege.project;

public class Card {
	private String suit;
	private String value;
        private boolean ace;
        
        private enum Suit {CLUBS, DIAMONDS, HEARTS, SPADES}; // enum for all possible suits
        public enum Value {ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING}; // enum for all possible card values

	public Card()
        {
            int suitNum = (int)(Math.random() * 4); // generate random number between 0 - 3
            this.suit = setSuit(suitNum); // set card suit to randomly generated suit
            
            int valueNum = (int)(Math.random() * 13); // generate random number between 0 - 12
            this.value = setValue(valueNum); // set card value to randomly generated value
            
            this.ace = "ACE".equals(this.value); // set boolen "ace" to true or false
	}

	public String getSuit()
        {
            return this.suit;
	}
        private String setSuit(int num)
        {
           Suit suit = Suit.values()[num];
           return suit.toString();
        }
        
	public String getValue()
        {
            return this.value;
	}
        private String setValue(int num)
        {
            Value value = Value.values()[num];
            return value.toString();
        }
        
	public boolean isAce()
        {
            return this.ace;
	}
}
