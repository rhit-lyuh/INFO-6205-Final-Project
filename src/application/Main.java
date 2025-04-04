package application;

import java.io.IOException;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Parent;
//import javafx.scene.layout.BorderPane;



//DONOT MODIFY THESE SETTING
//Use Javafx plugin in the Eclipse marketplace
//Min width: 400
//Min height: 300

public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) throws IOException {
		
		Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
		Scene scene = new Scene(root);
		
		primaryStage.setTitle("Final Project");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}


//SceneBuilder Version: 23.0.1
//FOR THE WARNING IN THE CONSOLE:
//xmlns="http://javafx.com/javafx/21.0.5" <= in the Main.fxml


//Basic Solution
//Delete module-info.java file
//In “(x) = Arguments” tab -> VM arguments, type in following arguments:
//--add-modules javafx.controls,javafx.fxml