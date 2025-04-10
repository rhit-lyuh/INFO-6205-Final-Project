package smartdietplanner.controller;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class DashboardController {

	
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
		try {
	        FXMLLoader loader = new FXMLLoader(getClass().getResource("/smartdietplanner/view/Goal.fxml"));
	        Parent homePage = loader.load();

	        Stage stage = (Stage) HomeNav.getScene().getWindow();
	        stage.setScene(new Scene(homePage));
	        stage.setTitle("Home");
	        stage.show();
	    } catch (IOException e) {
	        e.printStackTrace();
	        showAlert("Fail to open.", "CANNOT load the Home page.");
	    }
    }
	

	@FXML
    public void handleToDashboard() {
		showAlert("Alert", "This is Dashboard Page.");
        System.out.println("clicked");
    }
	
	@FXML
    public void handleToUser() {
	    try {
	        FXMLLoader loader = new FXMLLoader(getClass().getResource("/smartdietplanner/view/User.fxml"));
	        Parent userPage = loader.load();

	        Stage stage = (Stage) UserNav.getScene().getWindow();
	        stage.setScene(new Scene(userPage));
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
