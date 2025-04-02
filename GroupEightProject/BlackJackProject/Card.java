public class Card {
	private String _suit;
	private String _rank;
	private int _value;
	public Hand _unnamed_Hand_;
	public Deck ;

	public Card(String aSuit, String aRank, int aValue) {
		throw new UnsupportedOperationException();
	}

	public String getSuit() {
		return this._suit;
	}

	public String getRank() {
		return this._rank;
	}

	public int getValue() {
		return this._value;
	}

	public boolean isAce() {
		throw new UnsupportedOperationException();
	}
}