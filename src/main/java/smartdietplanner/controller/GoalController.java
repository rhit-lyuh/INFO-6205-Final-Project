package smartdietplanner.controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
//import java.util.List;
import java.util.Map;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import smartdietplanner.model.User;
import smartdietplanner.Main;

public class GoalController {
	
    //Bar
	@FXML
	private Label HomeNav;
	@FXML
	private Label DashboardNav;
	@FXML
	private Button UserNav;
	@FXML
	private Button FoodNav;

	
    
  	

	
	
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
	
	
	@FXML
	public void handleToFood() {
	    try {
	        FXMLLoader loader = new FXMLLoader(getClass().getResource("/smartdietplanner/view/Foodlist.fxml"));
	        Parent foodListPage = loader.load();

	        Stage stage = (Stage) FoodNav.getScene().getWindow();
	        stage.setScene(new Scene(foodListPage));
	        stage.setTitle("Food List");
	        stage.show();
	    } catch (IOException e) {
	        e.printStackTrace();
	        showAlert("Failed to open", "Unable to load the Food List page.");
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


