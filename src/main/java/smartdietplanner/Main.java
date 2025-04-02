package smartdietplanner;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        Label label = new Label("JavaFX Is Working Now.");
        StackPane root = new StackPane(label);
        Scene scene = new Scene(root, 400, 250);

        primaryStage.setTitle("SmartDietPlanner");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}