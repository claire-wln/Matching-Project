package hutchison.grant;

import javafx.scene.control.Button;
import javafx.scene.image.Image;

public class NewButton extends Button {
	private int row;
	private int col;
	
	public NewButton (int r, int c, String i){
		super();
		row = r;
		col = c;
		Image img = new Image(i);
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
