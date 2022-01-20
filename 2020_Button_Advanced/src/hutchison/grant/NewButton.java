package hutchison.grant;

import javafx.scene.control.Button;
import javafx.scene.image.Image;

public class NewButton extends Button {
	private int row;
	private int col;
	private String picName;
	public int state = 1;//1=facedown 2=flippedover 3=found(permanately flipped)
	
	public NewButton (int r, int c, String i){
		super();
		row = r; 
		col = c;
		picName = i;
		Image img = new Image(i);
	}
	
	public void updateState(int n) {
		state = n;
	}
	
	public int getRow(){
		return row;
	}
	
	public int getCol(){
		return col;
	}
	
	public int getState() {
		return state;
	}
	
	public String getName() {
		return picName;
	}
	
	@Override
	public String toString(){
		return "[" + String.valueOf(getRow()) + "," + String.valueOf(getCol())+"]";
	}
}
