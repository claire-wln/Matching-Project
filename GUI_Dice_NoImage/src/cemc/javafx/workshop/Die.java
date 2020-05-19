package cemc.javafx.workshop;

import java.util.Random;
public class Die {
	private int value;
	private int numSides;	
	private static Random rand = new Random();
	
	/**
	 * Create a default 6-sided Die
	 */
	public Die() {
		numSides = 6;
		value = roll();
	}
	
	/**
	 * Create a Die object with n sides.
	 * @param n number of sides
	 */
	public Die(int n) {
		numSides = n;
		value = roll();
	}

	/**
	 * Generate a random value to simulate a Die roll.
	 * @return value from 1 to numSides
	 */
	public int roll() {
		value = rand.nextInt(numSides) + 1; // 1 to numSides
		return value;
	}
}
