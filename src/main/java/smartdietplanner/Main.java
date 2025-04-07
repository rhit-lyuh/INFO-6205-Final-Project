package smartdietplanner;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
//import javafx.scene.layout.BorderPane;



//DONOT MODIFY THESE SETTING
//Use Javafx plugin in the Eclipse marketplace
//Min width: 1000
//Min height: 700
//<Image url="@../../../images/Logo-SDP.png" />

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {
    	
    	//test
    	URL fxmlUrl = getClass().getResource("/smartdietplanner/view/MainView.fxml");
    	System.out.println(fxmlUrl);
	   	    	
        Parent root = FXMLLoader.load(getClass().getResource("/smartdietplanner/view/MainView.fxml"));
        Scene scene = new Scene(root);

        primaryStage.setTitle("SmartDietPlanner");
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


//warning: in the working copy of 'src/application/Main.fxml', LF will be replaced by CRLF the next time Git touches it 
//Diff from Win and Mac (keep on Win)
//git config --global core.autocrlf input

//git config --global core.autocrlf true