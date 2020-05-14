package ics4ustart;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Driver {

	public static void main(String[] args) {

		// Setup constants for the Board
		final int ROWS = 7;
		final int COLS = 7;

		// create the board
		Board board = new Board(ROWS, COLS);
		board.display();
		Scanner in = new Scanner(System.in);

		boolean done = false;
		String value = "";

		int column = 0;

		while (!done) {
			column = getColumn(in);
			board.display();
		}
	}

	private static int getColumn(Scanner in) {
		boolean valid = false;
		int column = 0;
		while (!valid) {
			System.out.print("Which Column (1-7) :");
			if (in.hasNextInt()) {
				column = in.nextInt();
				if (column >= 1 && column <= 7) {
					valid = true;
				} else {
					System.out.println("Invalid range 1-7");
				}
			} else {
				System.out.println("Not a number.");
			}
			in.nextLine();
		}
		return column;
	}
}
