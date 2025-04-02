public class Card {
	private String suit;
	private String rank;
	private int value;
	

	public Card(String aSuit, String aRank, int aValue) {
		throw new UnsupportedOperationException();
	}

	public String getSuit() {
		return this.suit;
	}

	public String getRank() {
		return this.rank;
	}

	public int getValue() {
		return this.value;
	}

	public boolean isAce() {
		throw new UnsupportedOperationException();
	}
}
