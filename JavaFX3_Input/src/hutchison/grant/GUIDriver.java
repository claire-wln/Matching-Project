package hutchison.grant;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class GUIDriver extends Application {

	final static int WIDTH = 800;
	final static int HEIGHT = 400;
	
	@Override
	public void start(Stage stage) throws Exception {

		// Create root for our Scene Graph
		VBox root = new VBox();
		root.setAlignment(Pos.CENTER);
		root.setSpacing(10);

		Text question = new Text("What year was Java 1.0 released?");
		question.setFont(Font.font("Arial", 24));

		// Create a Button to trigger read of data from TextField
		Button btnCheckAnswer = new Button("Check Answer");

		// Create Empty Text for Response Text
		Text txtResult = new Text("");
		txtResult.setFont(Font.font("Arial", 80));
		
		// Create a TextField for Input 
		TextField txtAnswer = new TextField("");
		txtAnswer.setMaxWidth(50);

		// Button event handler
		btnCheckAnswer.setOnAction(e -> {
			int answer = Integer.parseInt(txtAnswer.getText());
			if (answer == 1996) {
				txtResult.setText("Correct");
				txtResult.setFill(Color.GREEN);
			} else {
				txtResult.setText("Try Again");
				txtResult.setFill(Color.RED);
			}
		});

		// Add Node to the graph
		root.getChildren().add(question);
		root.getChildren().add(txtAnswer);
		root.getChildren().add(btnCheckAnswer);
		root.getChildren().add(txtResult);

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
