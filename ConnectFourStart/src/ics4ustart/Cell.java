package ics4ustart;

public class Cell {
	private CellState state;
	
	
	public Cell(CellState cs) {
		state = cs;
		
	}
	

	
	public void setState (CellState cs){
		state = cs;
	}
	
	public CellState getState() {
		return state;
	}

	public String toString() {
		switch (state) {
		case P1:
			return "O";
		case P2:
			return "X";
		case EMPTY:
			return "-";
		default:
			return "-";
		}
	}
}
