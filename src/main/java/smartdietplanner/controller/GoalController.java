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
	private Label HomeAlert;
	@FXML
	private Label DashboardAlert;
	@FXML
	private Button UserAlert;
	
    //alert
  	private void showAlert(String title, String UserNameMsg) {
  		Alert alert = new Alert(AlertType.ERROR);
  	       alert.setTitle(title);
  	       alert.setHeaderText(null); 
  	       alert.setContentText(UserNameMsg);
  	       alert.showAndWait(); 
  	}
  	
//	Bar
	@FXML
    public void handleToHome() {
        showLoginAlert();
        System.out.println("clicked");
    }
	@FXML
    public void handleToDashboard() {
        showLoginAlert();
    }
	
	@FXML
    public void handleToUser() {
		showLoginAlert();
    }
	private void showLoginAlert() {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Alert");
        alert.setHeaderText(null);
        alert.setContentText("Plz login or register in ur account.");
        alert.showAndWait();
    }
	
}


