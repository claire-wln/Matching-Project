package hutchison.grant;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class MultiButton extends Application {
	private static final double BUTTON_WIDTH = 50;
	private static final double BUTTON_HEIGHT = 50;
	private static NewButton[][] slots = new NewButton[7][7];
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {				
		GridPane gridPane = new GridPane();		
		Scene mySceneGraph = new Scene(gridPane,500,500);	
		gridPane.setAlignment(Pos.TOP_CENTER);
		
		// setup slots
		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 7; j++) {
					slots[i][j] = new NewButton(i,j);
					slots[i][j].setPrefSize(BUTTON_WIDTH, BUTTON_HEIGHT);
					slots[i][j].setStyle("-fx-base: #C0C0C0;");
					slots[i][j].setText("[" + String.valueOf(i)+","+String.valueOf(j)+"]");

					slots[i][j].setOnAction(new EventHandler<ActionEvent>() {
			            @Override
			            public void handle(ActionEvent event) {
			            	System.out.println(((NewButton)event.getSource()).getRow());
			            }
			        });
			}
		}
		
		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 7; j++) {
				gridPane.add(slots[i][j], j,i+1);
			}
		}
		primaryStage.setScene(mySceneGraph);
		primaryStage.show();		
	}
}