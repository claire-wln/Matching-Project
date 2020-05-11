package hutchison.grant;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class GUIDriver extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		Font font = new Font("Arial", 30);
		VBox root = new VBox(25);
		root.setAlignment(Pos.CENTER);
		
		Text title = new Text("Rectangle Area Calculator");
		title.setFont(font);

		// 2 Text Fields for Rectangle Dimensions
		HBox rectDimensions = new HBox(25);
		rectDimensions.setAlignment(Pos.CENTER);
		Text labelWidth = new Text("Width");
		labelWidth.setFont(font);
		Text labelHeight = new Text("Height");
		labelHeight.setFont(font);
		rectDimensions.getChildren().addAll(labelWidth, labelHeight);
		
		// 2 TextFields for Rectangle Dimensions
		HBox dimensions = new HBox(25);
		dimensions.setAlignment(Pos.CENTER);
		
		TextField txtWidth = new TextField("");
		txtWidth.setMaxWidth(80);
		txtWidth.setFont(font);
		
		TextField txtHeight = new TextField("");
		txtHeight.setMaxWidth(80);
		txtHeight.setFont(font);
		dimensions.getChildren().addAll(txtWidth, txtHeight);

		// Circle Section
		Text titleCircle = new Text("Circle Area Calculator");
		titleCircle.setFont(font);
		
		// Circle Label
		Text lblRadius = new Text("Radius");
		lblRadius.setFont(font);
		
		// Circle TextField for input
		TextField txtRadius = new TextField("");
		txtRadius.setMaxWidth(80);
		txtRadius.setFont(font);
		
	
		// TextArea for Output
		TextArea area = new TextArea();
		area.setEditable(false);
		area.setFont(new Font("Courier", 14));
		area.setMinSize(200, 100);
		area.setMaxSize(200, 100);
		
		// Button for Rectangle Area
		Button btnRectArea = new Button("Calculate Rectangle Area");
		Button btnCircleArea = new Button("Calculate Circle Area");
		
		// Event handler for Rectangle
		btnRectArea.setOnAction(e -> {
			double width = Double.parseDouble(txtWidth.getText());
			double height = Double.parseDouble(txtHeight.getText());
			Rectangle rect = new Rectangle (width,height);
			String output = String.format("Area is %.1f square units", rect.getArea());
			area.setText(output);
		});
		
		// Event handler for Circles
		btnCircleArea.setOnAction(e -> {
			double radius = Double.parseDouble(txtRadius.getText());
			Circle circle = new Circle (radius);
			String output = String.format("Area is %.1f square units", circle.getArea());
			area.setText(output);
		});
		
		
		Scene scene = new Scene(root,400,800);
		root.getChildren().add(title);
		root.getChildren().add(rectDimensions);
		root.getChildren().add(dimensions);
		root.getChildren().add(btnRectArea);
		root.getChildren().add(titleCircle);
		root.getChildren().add(lblRadius);
		root.getChildren().add(txtRadius);
		root.getChildren().add(btnCircleArea);
		root.getChildren().add(area);
		
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
