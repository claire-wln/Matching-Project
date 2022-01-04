package hutchison.grant;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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

		Text question = new Text("JavaFX relies on the Java language feature called Inheritance.");
		question.setFont(Font.font("Arial", 24));

		Font font = Font.font("Arial", 24); // create a font object to reuse
				
		// Create 2 new Buttons
		HBox answers = new HBox();
		answers.setAlignment(Pos.CENTER);
		Button btnTrue = new Button("True");
		btnTrue.setFont(font);
		Button btnFalse = new Button("False");
		btnFalse.setFont(font);
		
		// Add Nodes to the HBox Graph
		answers.getChildren().addAll(btnTrue, btnFalse);
		
		// Create Empty Text for Response Text - Label
		Text txtResult = new Text("");
		txtResult.setFont(new Font("Arial", 40));

		// Button event handlers using Lambda expression (e is an event)
		btnTrue.setOnAction(event -> {
			txtResult.setText("Correct");
			txtResult.setFill(Color.GREEN);
		} );

		btnFalse.setOnAction(event -> {
			txtResult.setText("Try Again");
			txtResult.setFill(Color.PINK);
		} );
		
		// Add Node to the graph
		root.getChildren().addAll(question);
		root.getChildren().add(answers); // buttons
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
