package hutchison.grant;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TouchEvent;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class FloodFill extends Application {
	// create the board
	private static final int ROWS = 8;
	private static final int COLS = 8;
	private static Board board = new Board(ROWS, COLS);
	private static Button[][] slots = new Button[ROWS][COLS];

	public static void main(String[] args) {
		launch(args);
	}

	int counter = 0;

	@Override
	public void start(Stage primaryStage) throws Exception {
		final int WIDTH = 600;
		final int HEIGHT = 600;
		final int BUTTON_WIDTH = 100;
		final int BUTTON_HEIGHT = (HEIGHT - 80) / ROWS;

		primaryStage.setWidth(WIDTH);
		primaryStage.setHeight(HEIGHT);
		primaryStage.setTitle("FloodFill");

		VBox layout = new VBox();

		HBox selectors = new HBox();
		selectors.setPadding(new Insets(20, 20, 20, 20));

		Button btnRed = new Button();

		btnRed.setStyle("-fx-base: #ff0000;");
		btnRed.setPrefSize(WIDTH / 4, BUTTON_HEIGHT * 2);

		Button btnGreen = new Button();
		btnGreen.setStyle("-fx-base: #00ff00;");
		btnGreen.setPrefSize(WIDTH / 4, BUTTON_HEIGHT * 2);

		Button btnBlue = new Button();
		btnBlue.setPrefSize(WIDTH / 4, BUTTON_HEIGHT * 2);
		btnBlue.setStyle("-fx-base: #0000ff;");

		Button btnYellow = new Button();
		btnYellow.setStyle("-fx-base: #ffff00;");
		btnYellow.setPrefSize(WIDTH / 4, BUTTON_HEIGHT * 2);

		board.display();

		// setup slots
		for (int i = 0; i < board.getRows(); i++) {
			for (int j = 0; j < board.getCols(); j++) {
				slots[i][j] = new Button();
				slots[i][j].setPrefSize(BUTTON_WIDTH, BUTTON_HEIGHT);
				slots[i][j].setStyle("-fx-base: #000000;");
			}
		}

		updateBoard(board, slots);
		GridPane gridPane = new GridPane();
		gridPane.setAlignment(Pos.TOP_CENTER);

		for (int i = 0; i < board.getRows(); i++) {
			for (int j = 0; j < board.getCols(); j++) {
				gridPane.add(slots[i][j], j, i);
			}
		}
		Font font = new Font("Tahoma", 48);
		
		btnRed.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				counter++;
				board.fill(0, 0, board.getColor(0, 0), ColorState.RED);
				updateBoard(board, slots);
				if (board.isFilled()) {
					btnGreen.setDisable(true);
					btnYellow.setDisable(true);
					btnRed.setDisable(true);
					btnBlue.setDisable(true);
					// done scene
					StackPane sp = new StackPane();
					sp.setAlignment(Pos.CENTER);
					Label msg = new Label("Clicks: " + counter);
					Font font = new Font("Tahoma", 48);
					msg.setFont(font);
					sp.getChildren().add(msg);
					Scene done = new Scene(sp);
					primaryStage.setScene(done);

				}
			}
		});

		btnBlue.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				counter++;
				board.fill(0, 0, board.getColor(0, 0), ColorState.BLUE);
				updateBoard(board, slots);
				if (board.isFilled()) {
					btnGreen.setDisable(true);
					btnYellow.setDisable(true);
					btnRed.setDisable(true);
					btnBlue.setDisable(true);
					// done scene
					StackPane sp = new StackPane();
					sp.setAlignment(Pos.CENTER);
					Label msg = new Label("Clicks: " + counter);
					Font font = new Font("Tahoma", 48);
					msg.setFont(font);
					sp.getChildren().add(msg);
					Scene done = new Scene(sp);
					primaryStage.setScene(done);

				}
			}
		});

		btnGreen.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				counter++;
				board.fill(0, 0, board.getColor(0, 0), ColorState.GREEN);
				updateBoard(board, slots);
				if (board.isFilled()) {
					btnGreen.setDisable(true);
					btnYellow.setDisable(true);
					btnRed.setDisable(true);
					btnBlue.setDisable(true);
					// done scene
					StackPane sp = new StackPane();
					sp.setAlignment(Pos.CENTER);
					Label msg = new Label("Clicks: " + counter);
					Font font = new Font("Tahoma", 48);
					msg.setFont(font);
					sp.getChildren().add(msg);
					Scene done = new Scene(sp);
					primaryStage.setScene(done);

				}
			}
		});

		btnYellow.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				counter++;
				board.fill(0, 0, board.getColor(0, 0), ColorState.YELLOW);
				updateBoard(board, slots);
				if (board.isFilled()) {
					btnGreen.setDisable(true);
					btnYellow.setDisable(true);
					btnRed.setDisable(true);
					btnBlue.setDisable(true);
					// done scene
					StackPane sp = new StackPane();
					sp.setAlignment(Pos.CENTER);
					Label msg = new Label("Clicks: " + counter);
					Font font = new Font("Tahoma", 48);
					msg.setFont(font);
					sp.getChildren().add(msg);
					Scene done = new Scene(sp);
					primaryStage.setScene(done);
				}
			}
		});
		// Regular stage

		selectors.getChildren().addAll(btnRed, btnGreen, btnYellow, btnBlue);
		layout.getChildren().add(selectors);
		layout.getChildren().add(gridPane);
		Scene myScene = new Scene(layout);
		primaryStage.setScene(myScene);
		primaryStage.show();

	}

	private void updateBoard(Board board, Button[][] slots) {
		for (int i = 0; i < board.getRows(); i++) {
			for (int j = 0; j < board.getCols(); j++) {
				switch (board.getColor(i, j)) {
				case RED:
					slots[i][j].setStyle("-fx-base: #ff0000;");
					break;
				case BLUE:
					slots[i][j].setStyle("-fx-base: #0000ff;");
					break;
				case YELLOW:
					slots[i][j].setStyle("-fx-base: #ffff00;");
					break;
				case GREEN:
					slots[i][j].setStyle("-fx-base: #00ff00;");
					break;
				}
			}
		}
	}
}
