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
import javafx.scene.image.Image;
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

	private static final double WIDTH = 600;
	private static final double HEIGHT = 600;
	private static final int NUM_ROWS = 4;
	private static final int NUM_COLS = 5;
	static int numCardsClicked = 0;
	ArrayList<NewButton> buttons = new ArrayList<>();

	static NewButton[][] slots = new NewButton[NUM_ROWS][NUM_COLS];
	static ImageView back = new ImageView("Presto_Card.png");
	static int pairsMatched = 0;

	@Override
	public void start(Stage primaryStage) throws Exception {

		VBox main = new VBox();
		// add title and score stuff
		GridPane gridPane = new GridPane();
		Scene mySceneGraph = new Scene(main, WIDTH + 100, HEIGHT + 100);
		main.getChildren().add(gridPane);
		gridPane.setAlignment(Pos.CENTER);

		int turnCount = 0;
		setBoard();

		// setup slots as NewButton objects
		for (int i = 0; i < NUM_ROWS; i++) {
			for (int j = 0; j < NUM_COLS; j++) {

				// when you click button
				slots[i][j].setOnAction(e -> {
					if (((NewButton) e.getSource()).getState() == 1 && numCardsClicked == 0) {

						((NewButton) e.getSource()).updateState(2);
						System.out.println(numCardsClicked);
						numCardsClicked++;
						buttons.add((NewButton) e.getSource());

					} else if (((NewButton) e.getSource()).getState() == 1 && numCardsClicked == 1) {
						numCardsClicked++;
						// check if match or not
						System.out.println(numCardsClicked);
						buttons.add((NewButton) e.getSource());
						((NewButton) e.getSource()).updateState(2);

						if (buttons.get(0).getName().equals(buttons.get(1).getName())) {

							System.out.println("pair matched");
							// deactivate buttons
							buttons.get(0).setDisable(true);
							buttons.get(1).setDisable(true);
							pairsMatched++;

							if (pairsMatched == 10) {
								System.out.println("you win");
								// add graphics ig
							}

						} else {
							System.out.println("NO matched");
						}

					}

					if (numCardsClicked == 2) {
						buttons.clear();
						numCardsClicked = 0;
						System.out.println("reached numcards of 2");
					}
					refreshBoard();
				});

			}
		}

		for (int i = 0; i < NUM_ROWS; i++) {
			for (int j = 0; j < NUM_COLS; j++) {
				gridPane.add(slots[i][j], j, i + 1);
			}
		}
		primaryStage.setScene(mySceneGraph);
		primaryStage.show();

	}

	private static void setBoard() {
		ArrayList<String> images = new ArrayList<String>();
		for (int i = 0; i < 2; i++) {
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

		int imgVal = 0;

		for (int i = 0; i < NUM_ROWS; i++) {
			for (int j = 0; j < NUM_COLS; j++) {

				slots[i][j] = new NewButton(i, j, images.get(imgVal));

		
				ImageView back = new ImageView("Presto_Card.png");

				slots[i][j].setMinSize(WIDTH / NUM_COLS, HEIGHT / NUM_ROWS);
				slots[i][j].setMaxSize(WIDTH / NUM_COLS, HEIGHT / NUM_ROWS);

				slots[i][j].setGraphic(back);
				slots[i][j].updateState(1);
			}

			imgVal++;
		}

	}

	public void refreshBoard() {
		for (int i = 0; i < NUM_ROWS; i++) {
			for (int j = 0; j < NUM_COLS; j++) {
				if (slots[i][j].getState() == 1) {
					ImageView back = new ImageView("Presto_Card.png");
					slots[i][j].setGraphic(back);
				} else if (slots[i][j].getState() == 2) {
					Image image = slots[i][j].getImage();
					ImageView front = new ImageView(image);
					slots[i][j].setGraphic(front);
				}

			}
		}
	}
}
