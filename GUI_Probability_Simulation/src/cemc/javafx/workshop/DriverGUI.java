package cemc.javafx.workshop;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.TreeMap;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

// Simulation with Chart

public class DriverGUI extends Application {
	// Create Title
	private static Label lblTitle = new Label("Probability Simulator");
	private static Label lblSides = new Label("# of sides");
	private static TextField txtSides = new TextField("");
	private static Label lblNumDie = new Label("# of die");
	private static TextField txtNumDie = new TextField("");
	private static Label lblNumRolls = new Label("# of rolls");
	private static TextField txtNumRolls = new TextField("");
	private static Label lblErrorMessage = new Label();

	private static CategoryAxis xAxis = new CategoryAxis();
	private static NumberAxis yAxis = new NumberAxis();

	private static BarChart<String, Number> bc = new BarChart<String, Number>(xAxis, yAxis);

	// Allocate a TreeMap to contain dice sums
	private static TreeMap<Integer, Integer> results = new TreeMap<>();

	@Override
	public void start(Stage stage) throws Exception {

		GridPane grid = new GridPane();
		grid.setVgap(20);

		int numWidth = String.valueOf(Integer.MAX_VALUE).length();
		// Create input area
		grid.add(lblSides, 0, 0);
		grid.add(txtSides, 1, 0);
		txtSides.setMinWidth(numWidth * 30);
		txtSides.setMaxWidth(numWidth * 30);

		grid.add(lblNumDie, 0, 1);
		grid.add(txtNumDie, 1, 1);
		txtNumDie.setMinWidth(numWidth * 30);
		txtNumDie.setMaxWidth(numWidth * 30);

		grid.add(lblNumRolls, 0, 2);
		grid.add(txtNumRolls, 1, 2);
		txtNumRolls.setMinWidth(numWidth * 30);
		txtNumRolls.setMaxWidth(numWidth * 30);

		Button btnRun = new Button("Run Simulation");

		VBox input = new VBox(10);
		input.setAlignment(Pos.CENTER);
		input.getChildren().addAll(grid, btnRun);

		// Create BorderPane and add nodes
		BorderPane bp = new BorderPane();
		bp.setTop(lblTitle);
		bp.setLeft(input);
		bp.setCenter(bc);
		bp.setBottom(lblErrorMessage);

		BorderPane.setAlignment(lblTitle, Pos.TOP_CENTER);
		BorderPane.setAlignment(lblErrorMessage, Pos.TOP_CENTER);

		// Create a scene, set the root Node and optional the dimensions
		Scene scene = new Scene(bp, 1000, 400);

		// Apply the CSS for default fonts and background colors etc..
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

		// Set the stage with the scene
		stage.setScene(scene);
		stage.show();
		stage.setMaximized(true);

		btnRun.setOnAction(e -> {
			simulationHandler();
			xAxis.setLabel("Sum");
			yAxis.setLabel("Number");

			XYChart.Series series1 = new XYChart.Series();
			ArrayList<String> keyList = new ArrayList<>();

			// Clear previous data if button pressed more than once
			// series1.getData().clear();

			for (Integer key : results.keySet()) {
				series1.getData().add(new XYChart.Data(String.valueOf(key), results.get(key)));
				keyList.add(String.valueOf(key));
			}
			bc.setLegendVisible(false);

			// This is needed as auto ranging of x-axis labels is broken
			xAxis.setCategories(FXCollections.observableArrayList(keyList));
			bc.getData().clear();
			bc.layout();
			bc.getData().add(series1);
		});
	}

	private void simulationHandler() {
		// Empty results for new simulation
		results.clear();
		lblErrorMessage.setText(""); // clear out error messages

		try {
			int numRolls = Integer.parseInt(txtNumRolls.getText());
			int numSides = Integer.parseInt(txtSides.getText());
			int numDie = Integer.parseInt(txtNumDie.getText());

			// Allocate the proper numer of Die for each roll, and store their sums
			for (int i = 0; i < numRolls; i++) {
				// allocate enough Die objects for each roll
				Die[] dice = new Die[numDie];
				int sum = 0;
				for (int j = 0; j < numDie; j++) {
					dice[j] = new Die(numSides);
					sum += dice[j].roll();
				}

				// If first die sum store 1, else increment stored value
				if (!results.containsKey(sum)) {
					results.put(sum, 1);
				} else {
					results.put(sum, results.get(sum) + 1);
				}
			}
		} catch (NumberFormatException e) {
			lblErrorMessage.setText("Invalid data provided: " + e.getLocalizedMessage());
		}	 catch (Exception e) {
			lblErrorMessage.setText("Error occurred, try again: " + e.getLocalizedMessage());
		}

	}

	public static void main(String[] args) {
		// Call the JavaFX graphics interface
		launch(args);
	}

}
