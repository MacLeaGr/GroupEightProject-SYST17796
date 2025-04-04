package ca.sheridancollege.project;

public abstract class HouseRules // set of rules that dealer abides by, can be modified by Rule Subclasses
{
	public abstract boolean shouldHit(Hand aHand);
}
