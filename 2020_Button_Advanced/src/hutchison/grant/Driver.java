package hutchison.grant;


import java.util.ArrayList;
import java.util.Collections;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Driver extends Application {

	public static void main(String[] args) {
		launch(args);
	}
	
	private final double WIDTH = 700;
	private final double HEIGHT = 800;
	private final int NUM_ROWS = 4;
	private final int NUM_COLS = 5;
	int numCardsClicked = 0;
	ArrayList <NewButton> buttons = new ArrayList<>();
	
	private NewButton[][] slots = new NewButton[NUM_ROWS][NUM_COLS];
	
	@Override
	public void start(Stage primaryStage) throws Exception {				
		
		VBox main = new VBox();
		//add title and score stuff
		GridPane gridPane = new GridPane();		
		Scene mySceneGraph = new Scene(main,WIDTH+100,HEIGHT+100);
		main.getChildren().add(gridPane);
		gridPane.setAlignment(Pos.CENTER);
		
		ArrayList<String> images = new ArrayList<String>();
		for (int i=0; i<2;i++) {
			images.add("CarrotShopping.png");
			images.add("CatCarCrash.png");
			images.add("Chucky.png");
			images.add("FrogTeaTime.png");
			images.add("Geoff.png");
			images.add("KnockOffPussInBoots.png");
			images.add("LizardGoingThroughIt.png");
			images.add("Queen.png");
			images.add("RunwaySphynx.png");
			images.add("ThisCouldBeSofiasDogWhoKnows.png");
		}
		Collections.shuffle(images);
		
		ImageView back = new ImageView("Presto_Card.png");
		
		int imgVal = 0;
		int turnCount = 0;
						
		// setup slots as NewButton objects
		for (int i = 0; i < NUM_ROWS; i++) {
			for (int j = 0; j < NUM_COLS; j++) {
					slots[i][j] = new NewButton(i,j,images.get(imgVal));
					
					ImageView front = new ImageView(images.get(imgVal));
					
					slots[i][j].setMinSize(WIDTH/NUM_COLS, HEIGHT/NUM_ROWS);
					slots[i][j].setMaxSize(WIDTH/NUM_COLS, HEIGHT/NUM_ROWS);
					slots[i][j].setGraphic(back);
					
					//when you click button
					slots[i][j].setOnAction(e ->{
						if (((NewButton) e.getSource()).getState() == 1 && numCardsClicked < 2) {
							((NewButton) e.getSource()).setGraphic(front);
							((NewButton) e.getSource()).updateState(2);
							numCardsClicked++;
							buttons.add((NewButton) e.getSource());
							
							if (numCardsClicked == 2) {
								
								
								
								System.out.println("pair selected");
								if (buttons.get(0).getName().equals(buttons.get(1).getName())) {
									
									System.out.println("pair matched");
									//deactivate buttons
									
								} else {
									
									buttons.get(0).updateState(1);
									buttons.get(0).setGraphic(back);
									buttons.get(1).updateState(1);
									buttons.get(1).setGraphic(back);
									buttons.clear();
									
								}
								
							numCardsClicked=0;	
								
							}
										
						}
						
						
						
					});
					imgVal++;
			}
		}
		
		for (int i = 0; i < NUM_ROWS; i++) {
			for (int j = 0; j < NUM_COLS; j++) {
				gridPane.add(slots[i][j], j,i+1);
			}
		}
		primaryStage.setScene(mySceneGraph);
		primaryStage.show();		
	}
}