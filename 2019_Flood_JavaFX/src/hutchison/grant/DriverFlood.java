package hutchison.grant;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class DriverFlood {

	public static void main(String[] args) throws InterruptedException {

		Scanner in = new Scanner(System.in);
		
		// Ask user for size of board
		System.out.print("How many rows in board?    : ");
		final int ROWS = Integer.parseInt(in.nextLine());
		System.out.print("How many columns in board? : ");
		final int COLS = Integer.parseInt(in.nextLine());
		
		// create the board
		Board board = new Board(ROWS, COLS);
		board.display();

		// List of possible input values
		List<String> values = new ArrayList<>();
		values.add("R");
		values.add("G");
		values.add("B");
		values.add("Y");
		values.add("X");
	
		boolean done = false;
		String value = "";
		
		// Always fill from top left corner
		int x = 0;
		int y = 0;

		int turns = 0;
		System.out.print("New Color (RGBY) (X to finish): ");
		while (!done && in.hasNextLine()) {
			x = 0;
			y = 0;
			value = in.nextLine().trim().toUpperCase();
			if (values.contains(value)) {
				if (value.equals("X")) {
					done = true;
				} else {
					if (value.equals("R")) {
						board.fill(x, y, board.getColor(x, y), ColorState.RED);
						done = board.check(ColorState.RED);
					} else if (value.equals("B")) {
						board.fill(x, y, board.getColor(x, y), ColorState.BLUE);
						done = board.check(ColorState.BLUE);
					} else if (value.equals("G")) {
						board.fill(x, y, board.getColor(x, y), ColorState.GREEN);
						done = board.check(ColorState.GREEN);
					} else if (value.equals("Y")) {
						board.fill(x, y, board.getColor(x, y), ColorState.YELLOW);
						done = board.check(ColorState.YELLOW);
					}
				}
			}
			board.display();
			turns++;
			if (!done) {
				System.out.print("New Color (RGBY) (X to finish): ");
			} 
		}
		System.out.print("It took you only " + turns + " turns.");

	}
}
