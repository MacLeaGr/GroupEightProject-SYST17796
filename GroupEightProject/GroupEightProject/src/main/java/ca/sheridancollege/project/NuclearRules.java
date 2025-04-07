package ca.sheridancollege.project;

public class NuclearRules extends HouseRules { // ruleset that modifies house rules, makes dealer act differently

	 @Override
    public boolean shouldHit(Hand aHand) {
        int score = aHand.getHandValue();
        int aceCount = 0;
        
        // Count the number of Aces in the hand
        for (Card card : aHand.getCards()) {
            if (card.isAce()) {
                aceCount++;
            }
        }
        
        // Check if the score is less than 17 or if it is 17 but the hand is soft
        if (score < 17) {
            return true; // Always hit if score is less than 17
        } else if (score == 17 && aceCount > 0) {
            return true; // Hit if score is 17 and it's a soft hand (because it includes at least one Ace)
        }
        
        return false; // Stand if score is 17 or greater and not a soft hand
    }
}
