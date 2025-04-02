public class Player {
	private String _name;
	private int _score;
	private Hand _hand;

	public String getName() {
		return this._name;
	}

	public int getScore() {
		return this._score;
	}

	public void stand() {
		throw new UnsupportedOperationException();
	}

	public void hit() {
		throw new UnsupportedOperationException();
	}

	public void doubleDown() {
		throw new UnsupportedOperationException();
	}

	public void playTurn() {
		throw new UnsupportedOperationException();
	}

	public void split() {
		throw new UnsupportedOperationException();
	}
}
