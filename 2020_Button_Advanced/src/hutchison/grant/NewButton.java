package hutchison.grant;

import javafx.scene.control.Button;

public class NewButton extends Button {
	private int row;
	private int col;
	
	public NewButton (int r, int c){
		super();
		row = r;
		col = c;
	}
	
	public int getRow(){
		return row;
	}
	public int getCol(){
		return col;
	}
	
	@Override
	public String toString(){
		return "[" + String.valueOf(getRow()) + "," + String.valueOf(getCol())+"]";
	}
}
