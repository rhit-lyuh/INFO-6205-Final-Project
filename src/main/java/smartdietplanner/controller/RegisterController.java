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
import smartdietplanner.model.UserData;
import smartdietplanner.Main;

public class RegisterController {

	//Data Field
    @FXML
    private TextField userNameReg;
    @FXML
    private TextField passwordReg;
    @FXML
	private Button RegstBtn;
    @FXML
    private Label BackToSign;
    
    //Bar
	@FXML
	private Label HomeAlert;
	@FXML
	private Label DashboardAlert;
	@FXML
	private Button UserAlert;
    
    //User List
    private static List<User> users = new ArrayList<>();
    //File Router
    static File dataFile = Main.getUserDataFile();
    
    
    @FXML
    public void getRegSubmit() {
		String userName = userNameReg.getText();
		String password = passwordReg.getText();	

		if (userName.isEmpty() || password.isEmpty()) {
			showAlert("Try again.", "CANNOT be empty.");
			return;
		}
						
		//New a User Object
		//userID userName password 		
		User user = new User(userName, password);
		
		//Set user name and uuid to UserData
		UserData.getData().setUserData(userName, user.getUserId());
		
		if (!isUserExists(user)) {  //Check User File success or not
            users.add(user);
            if (saveUserToFile(user)) {
            	navigateToLoginPage();  //Jump to the Login page
            } else {
                showAlert("Fail to store.", "Can't store the data.");
            }
        } else {
        	showAlert("Fail to sign in.", "Existed user name.");  //show alert
        }
		
		//C:\Users\(username)
        System.out.println("saveUserToFile: " + saveUserToFile(user));  //test

        
        //TEST 
        //test_2
        //123456
		
		//Hash Map
		Map<String, String> userData = new HashMap<>();
		
		userData.put("key_1", userName);
		userData.put("key_2", password);
		
		
		System.out.println("User data file: " + dataFile.getAbsolutePath());  //test
		
		//test
		System.out.println("User ID is " + user.getUserId());
		System.out.println("User Name is " + userData.get("key_1"));
		System.out.println("Password is " + userData.get("key_2"));
																		
    }
    
	private boolean isUserExists(User user) {
        return users.stream().anyMatch(existingUser -> existingUser.getUserName().equals(user.getUserName()));
    }
	
	private void navigateToLoginPage() {
	    try {
	        FXMLLoader loader = new FXMLLoader(getClass().getResource("/smartdietplanner/view/MainView.fxml"));
	        Parent loginPage = loader.load();

	        Stage stage = (Stage) userNameReg.getScene().getWindow();
	        stage.setScene(new Scene(loginPage));
	        stage.setTitle("Login");
	        stage.show();
	    } catch (IOException e) {
	        e.printStackTrace();
	        showAlert("Fail to open.", "CANNOT load the Login page.");
	    }
	}
    
	@FXML
	private void BackToLoginPage(MouseEvent event) {
	    try {
	        FXMLLoader loader = new FXMLLoader(getClass().getResource("/smartdietplanner/view/MainView.fxml"));
	        Parent loginPage = loader.load();

	        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
	        stage.setScene(new Scene(loginPage));
	        stage.setTitle("Login");
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
  	
	private static boolean saveUserToFile(User user) {
		
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(dataFile, true))) {
            writer.write(user.getUserName() + "," + user.getPassword());
            writer.newLine();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Can't store the data.");  //test
            return false;
        }
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
