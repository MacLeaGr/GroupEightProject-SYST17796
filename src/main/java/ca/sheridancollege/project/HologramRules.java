package ca.sheridancollege.project;

public class HologramRules extends HouseRules { // ruleset that modifies house rules, makes dealer act differently

	@Override
	public boolean shouldHit(Hand aHand) {
		throw new UnsupportedOperationException();
	}
}
