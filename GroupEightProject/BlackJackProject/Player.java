public class Player {
	private String name;
	private int score;
	private Hand hand;

	public String getName() {
		return this.name;
	}

	public int getScore() {
		return this.score;
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
