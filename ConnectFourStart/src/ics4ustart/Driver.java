package ics4ustart;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

/**
 * Text (console) based driver for testing purposes.
 * @author Hutchison
 *
 */
public class Driver {

	public static void main(String[] args) {

		// Setup constants for the Board
		final int ROWS = 6;
		final int COLS = 7;

		// create the board
		Board board = new Board(ROWS, COLS);
		board.display();
		
		// console input
		Scanner in = new Scanner(System.in);
		boolean done = false;
		String value = "";
		int column = 0;

		while (!done) {
			column = getColumn(in, 1, COLS); // include min and max
			board.display();
		}
	}
	
/**
 * Helper method to ensure column value is valid.
 * @param in
 * @return
 */
	private static int getColumn(Scanner in, int min, int max) {
		boolean valid = false;
		int column = 0;
		
		while (!valid) {
			String prompt = String.format("Which column (%d,%d) :",min,max); 
			System.out.print(prompt);
			if (in.hasNextInt()) {
				column = in.nextInt();
				if (column >= min && column <= max) {
					valid = true;
				} else {
					System.out.println("Invalid numeric value provided.");
				}
			} else {
				System.out.println("Not a number.");
			}
			in.nextLine();
		}
		return column;
	}
}
