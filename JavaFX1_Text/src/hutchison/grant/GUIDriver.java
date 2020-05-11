package hutchison.grant;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class GUIDriver extends Application {

	final static int WIDTH = 800;
	final static int HEIGHT = 400;
	@Override
	public void start(Stage stage) throws Exception {

		// Create root for our Scene Graph
		StackPane root = new StackPane();
		
		// Create Node
		Text message = new Text("Comic Sans is Evil");
		message.setFont(Font.font("Comic Sans MS", 100));
		message.setFill(Color.YELLOW);
		
		// Add Node to the graph
		root.getChildren().add(message);
		
		// create scene using scene graph
		Scene scene = new Scene(root, WIDTH, HEIGHT, Color.ALICEBLUE);
		
		// associate the scene graph with the stage
		stage.setScene(scene);
		stage.show();
	}
	
	

	public static void main(String[] args) {
		launch(args);
	}


}
