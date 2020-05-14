package ics4ustart;

import java.util.Random;

/**
 * Represents a 2 dimensional Board for Grid based games.
 * @author Hutchison
 * @version 1.0
 *
 */
public class Board {
	
	private Cell[][] board;
	private int rows;
	private int cols;

	/**
	 * Constructor for Boards.
	 * @param aRows number of rows in board
	 * @param aCols number of columns in board
	 */
	public Board(int aRows, int aCols) {
		board = new Cell[aRows][aCols];
		rows = aRows;
		cols = aCols;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				board[i][j] = new Cell(CellState.EMPTY); // no color
			}
		}
	}
	
	/**
	 * Obtain the current number of rows.
	 * @return number of rows
	 */
	public int getRows(){
		return rows;
	}
	
	/**
	 * Obtain the current number of columns.
	 * @return number of columns
	 */
	public int getCols(){
		return cols;
	}
	
	/**
	 * Check if a proposed location is valid.
	 * @param rowIndex row index to check
	 * @param colIndex column index to check
	 * @return true if index value is valid, otherwise false
	 */
	public boolean isValid(int rowIndex, int colIndex){
		return (rowIndex>=0 && rowIndex < rows) && (colIndex>=0 && colIndex < cols);
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
