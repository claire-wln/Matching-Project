
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class HarmonicGUIDriver extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("Harmonic Numbers");

		StackPane root = new StackPane();

		final NumberAxis xAxis = new NumberAxis();
		final NumberAxis yAxis = new NumberAxis();
		final ScatterChart<Number, Number> sc = new ScatterChart<Number, Number>(xAxis, yAxis);
		xAxis.setLabel("Number");
		yAxis.setLabel("Harmonic");
		sc.setTitle("Harmonic Numbers");

		XYChart.Series series1 = new XYChart.Series();
		sc.setLegendVisible(false);
		
		// generate the corresponding Harmonic number

		for (int i = 1; i <= 100; i++) {
			series1.getData().add(new XYChart.Data(i, Harmonic.harmonic(i)));
		}
		
		sc.getData().add(series1);
		root.getChildren().add(sc);

		primaryStage.setScene(new Scene(root, 1000, 500));
		primaryStage.show();
	}

}
