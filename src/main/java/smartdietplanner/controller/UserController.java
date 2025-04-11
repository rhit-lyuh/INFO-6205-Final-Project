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
	
	//User
	@FXML
	private Label userName;
	@FXML
	private Label uuid;
	
	//Btn
	@FXML
	private Button logOut;  //handleLogOut
	@FXML
	private Button toGoal;  //handleToHome
	@FXML
	private Button toDash;  //handleToDashboard
	@FXML
	private Button toPlan;  //handleToPlan
	
	
	
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
	    public void handleToPlan() {
			try {
		        FXMLLoader loader = new FXMLLoader(getClass().getResource("/smartdietplanner/view/Plan.fxml"));
		        Parent planPage = loader.load();

		        Stage stage = (Stage) toPlan.getScene().getWindow();
		        stage.setScene(new Scene(planPage));
		        stage.setTitle("Plan");
		        stage.show();
		    } catch (IOException e) {
		        e.printStackTrace();
		        showAlert("Fail to open.", "CANNOT load the Plan page.");
		    }
	    }
		
		@FXML
	    public void handleToUser() {
			showAlert("Alert", "This is User Page.");
	    }
		
		
		//Log out
		@FXML
	    public void handleLogOut() {
			try {
		        FXMLLoader loader = new FXMLLoader(getClass().getResource("/smartdietplanner/view/MainView.fxml"));
		        Parent loginPage = loader.load();

		        Stage stage = (Stage) HomeNav.getScene().getWindow();
		        stage.setScene(new Scene(loginPage));
		        stage.setTitle("Log in");
		        stage.show();
		    } catch (IOException e) {
		        e.printStackTrace();
		        showAlert("Fail to open.", "CANNOT load the Login page.");
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

