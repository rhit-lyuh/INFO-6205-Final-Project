package smartdietplanner;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.stage.Stage;


import java.io.File;
import java.io.IOException;
import java.net.URL;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import smartdietplanner.model.User;
//import javafx.scene.layout.BorderPane;
import smartdietplanner.Main;



//DONOT MODIFY THESE SETTING
//Use Javafx plugin in the Eclipse marketplace
//Min width: 1000
//Min height: 700
//<Image url="@../../../images/Logo-SDP.png" />

public class Main extends Application {
	
    // IO File
    private static File userDataFile;

    @FXML
    private Menu userNameField;

    // Static reference to the primary stage
    private static Stage primaryStage;
    
    //user -> if no user: null 
    private static User currentUser;
	
    //Getter -> user
    public static User getCurrentUser() {
		return currentUser;
	}
    // Setter -> user status(login or out)
    public static void setUserStatus(User user) {
    	currentUser = user;
    }

    // Getter -> User data file
    public static File getUserDataFile() {
        return userDataFile;
    }
	
	
	

    @Override
    public void start(Stage primaryStage) throws IOException {
    	// Initialize the primary stage
        Main.primaryStage = primaryStage;

        // Create user data directory
        String userHome = System.getProperty("user.home");
        System.out.println(userHome);
    	File appDataDir = new File(userHome, "SmartDietPlanner");
        if (!appDataDir.exists()) {
            appDataDir.mkdirs();
        }
    	userDataFile = new File(appDataDir, "SDP_userdata.txt");
    	
    	
    	//test
    	URL fxmlUrl = getClass().getResource("/smartdietplanner/view/MainView.fxml");
    	System.out.println(fxmlUrl);
    	
    	try {
    		Parent root = FXMLLoader.load(getClass().getResource("/smartdietplanner/view/MainView.fxml"));
            Scene scene = new Scene(root);

            primaryStage.setTitle("SmartDietPlanner");
            primaryStage.setScene(scene);
            primaryStage.show();
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
	   	    	
        
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