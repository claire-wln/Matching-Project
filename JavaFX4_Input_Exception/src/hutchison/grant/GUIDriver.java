package hutchison.grant;

import java.io.FileInputStream;

import javafx.application.Application;

import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
		FileInputStream input = new FileInputStream("/javalogo.png");
		Image image = new Image(input);
		ImageView background = new ImageView(image);
		background.setPreserveRatio(true);
		background.setFitWidth(WIDTH);
		background.setFitHeight(HEIGHT);

		StackPane root = new StackPane();
			
		// Create root for our Scene Graph
		VBox vbox = new VBox();
		vbox.setSpacing(20);
		vbox.setAlignment(Pos.CENTER);

		Text question = new Text("What year was Java 1.0 released?");
		question.setFont(Font.font("Arial", 24));

		// Create a TextField for Input
		TextField txtAnswer = new TextField(""); // Must be static
		txtAnswer.setMaxWidth(50);

		// Create a Button to trigger read of data from TextField
		Button btnCheckAnswer = new Button("Check Answer");

		// Create Empty Text for Response Text
		Text txtResult = new Text("");
		txtResult.setFont(Font.font("Arial", 40));

		// Button event handler
		btnCheckAnswer.setOnAction(e -> {
			try {
				if (txtAnswer.getText().isEmpty()) {
					throw new Exception("You forgot to provide an answer.");
				}
				
				int answer = Integer.parseInt(txtAnswer.getText());
				if (answer == 1996) {
					txtResult.setText("Correct");
					txtResult.setFill(Color.GREEN);
				} else {
					txtResult.setText("Try Again");
					txtResult.setFill(Color.RED);
				}
			} catch (Exception exp) {
				txtResult.setText("Error: " + exp.getMessage());
			}
		});

		// Add Node to the graph
		vbox.getChildren().add(question);
		vbox.getChildren().add(txtAnswer);
		vbox.getChildren().add(btnCheckAnswer);
		vbox.getChildren().add(txtResult);
		
		root.getChildren().addAll(background,vbox);
		
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
