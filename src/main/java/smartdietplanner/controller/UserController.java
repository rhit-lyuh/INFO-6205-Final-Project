package smartdietplanner.controller;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class UserController {
	
    //Bar
	@FXML
	private Label HomeNav;
	@FXML
	private Label DashboardNav;
	@FXML
	private Button UserNav;
	
	
	
	//Bar
		@FXML
	    public void handleToHome() {
	        showAlert("Alert", "This is Home Page.");
	        System.out.println("clicked");
	    }
		@FXML
	    public void handleToDashboard() {
		    try {
		        FXMLLoader loader = new FXMLLoader(getClass().getResource("/smartdietplanner/view/Dashboard.fxml"));
		        Parent loginPage = loader.load();

		        Stage stage = (Stage) DashboardNav.getScene().getWindow();
		        stage.setScene(new Scene(loginPage));
		        stage.setTitle("Dashboard");
		        stage.show();
		    } catch (IOException e) {
		        e.printStackTrace();
		        showAlert("Fail to open.", "CANNOT load the Dashboard page.");
		    }
	    }
		
		@FXML
	    public void handleToUser() {
		    try {
		        FXMLLoader loader = new FXMLLoader(getClass().getResource("/smartdietplanner/view/User.fxml"));
		        Parent loginPage = loader.load();

		        Stage stage = (Stage) DashboardNav.getScene().getWindow();
		        stage.setScene(new Scene(loginPage));
		        stage.setTitle("User");
		        stage.show();
		    } catch (IOException e) {
		        e.printStackTrace();
		        showAlert("Fail to open.", "CANNOT load the User page.");
		    }
	    }

		
		//alert
	  	private void showAlert(String title, String UserNameMsg) {
	  		Alert alert = new Alert(AlertType.ERROR);
	  	       alert.setTitle(title);
	  	       alert.setHeaderText(null); 
	  	       alert.setContentText(UserNameMsg);
	  	       alert.showAndWait(); 
	  	}
		

}

