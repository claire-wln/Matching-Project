package hutchison.grant;

import java.util.Random;

public class Board {
	private Cell[][] board;
	private int rows;
	private int cols;

	public Board(int aRows, int aCols) {
		board = new Cell[aRows][aCols];
		rows = aRows;
		cols = aCols;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				board[i][j] = new Cell(randomColor()); // no color
			}
		}
	}
	
	public int getRows(){
		return rows;
	}
	
	public int getCols(){
		return cols;
	}
	
	final static Random RAND = new Random();
	final static int SIZE = ColorState.values().length;
	final static ColorState[] STATES = ColorState.values();

	private static ColorState randomColor() {
		return STATES[RAND.nextInt(SIZE)];
	}
	public ColorState getColor(int x, int y) {
		return board[x][y].getColor();
	}

	public boolean isValid(int x, int y){
		return (x>=0 && x < rows) && (y>=0 && y < cols);
	}
	
	private void unVisit(){
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				board[i][j].setVisited(false);
			}
		}
	}
	
	public void fill(int x, int y, ColorState newColor, ColorState replaceColor)  {
		if (!isValid(x,y)) { return; }
		if (newColor==replaceColor) { return; }
		if (board[x][y].hasVisited()) { return; }
		if (board[x][y].getColor()!=newColor) { return; }
		// not the same color
		board[x][y].setColor(replaceColor);
		board[x][y].setVisited(true);
	//	display();
		fill(x - 1, y, newColor,replaceColor);
        fill(x + 1, y, newColor,replaceColor);
        fill(x, y - 1, newColor,replaceColor);
        fill(x, y + 1, newColor,replaceColor);
        unVisit();
        return;	
	}
		
	public boolean isFilled() {
		ColorState cs = board[0][0].getColor();
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (board[i][j].getColor()!=cs)  {return false; }
			}
		}
		return true;
		
	}
	
	public boolean check(ColorState cs){
		
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (board[i][j].getColor()!=cs)  {return false; }
			}
		}
		return true;
	}
	
	public void display() {
		System.out.println("BOARD");
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				System.out.printf("%s ", board[i][j]);
			}
			System.out.println();
		}
	}
}
