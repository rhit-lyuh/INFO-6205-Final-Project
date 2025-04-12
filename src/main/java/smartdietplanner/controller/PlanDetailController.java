package smartdietplanner.controller;

import java.io.IOException;
import java.util.UUID;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import smartdietplanner.model.UserData;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class PlanDetailController {
	
	//Bar
	@FXML
	private Label HomeNav;
	@FXML
	private Label DashboardNav;
	@FXML
	private Button UserNav;
	@FXML
	private Button back;
	
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
		try {
	        FXMLLoader loader = new FXMLLoader(getClass().getResource("/smartdietplanner/view/Dashboard.fxml"));
	        Parent dashboardPage = loader.load();

	        Stage stage = (Stage) DashboardNav.getScene().getWindow();
	        stage.setScene(new Scene(dashboardPage));
	        stage.setTitle("Dashboard");
	        stage.show();
	    } catch (IOException e) {
	        e.printStackTrace();
	        showAlert("Fail to open.", "CANNOT load the Dashboard page.");
	    }
    }
	
	
	@FXML
    public void handleToUser() {
		showAlert("Alert", "This is User Page.");
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
