package flex;

import java.awt.Button;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class FlexWrapButtons extends Application {

	@Override
	public void start(Stage primaryStage) {
		// Create a flow pane with horizontal orientation and wrap on
		FlowPane flowPane = new FlowPane();
		flowPane.setHgap(10);
		flowPane.setStyle("-fx-background-color: #FFFFFF; -fx-padding: 10px; -fx-wrap-text: true;");

		// Create some buttons to add to the flow pane
		Button button1 = new Button("Button 1");
		Button button2 = new Button("Button 2");
		Button button3 = new Button("Button 3");
		Button button4 = new Button("Button 4");
		Button button5 = new Button("Button 5");
		Button button6 = new Button("Button 6");
		Button button7 = new Button("Button 7");
		Button button8 = new Button("Button 8");
		Button button9 = new Button("Button 9");
		Button button10 = new Button("Button 10");

		// Add the buttons to the flow pane
		flowPane.getChildren();

		// Create a scene and set it on the stage
		Scene scene = new Scene(flowPane, 300, 200);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}