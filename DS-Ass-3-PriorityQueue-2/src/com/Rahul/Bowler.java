package com.Rahul;

// TODO: Auto-generated Javadoc
/**
 * The Class Bowler.
 */
public class Bowler {
	
	/** The bowler name. */
	String bowlerName;
	
	/** The balls left. */
	int ballsLeft;
	
	/**
	 * Instantiates a new bowler.
	 *
	 * @param bowlerName the bowler name
	 * @param ballsLeft the balls left
	 */
	public Bowler(String bowlerName, int ballsLeft) {
		super();
		this.bowlerName = bowlerName;
		this.ballsLeft = ballsLeft;
	}
	
	/**
	 * Gets the bowler name.
	 *
	 * @return the bowler name
	 */
	public String getBowlerName() {
		return bowlerName;
	}
	
	/**
	 * Sets the bowler name.
	 *
	 * @param bowlerName the new bowler name
	 */
	public void setBowlerName(String bowlerName) {
		this.bowlerName = bowlerName;
	}
	
	/**
	 * Gets the balls left.
	 *
	 * @return the balls left
	 */
	public int getBallsLeft() {
		return ballsLeft;
	}
	
	/**
	 * Sets the balls left.
	 *
	 * @param ballsLeft the new balls left
	 */
	public void setBallsLeft(int ballsLeft) {
		this.ballsLeft = ballsLeft;
	}
	
}
