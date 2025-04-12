package smartdietplanner.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.UUID;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import smartdietplanner.model.User;
import smartdietplanner.model.UserData;
import smartdietplanner.Main;

public class MainController {
	
	//Data Field
    @FXML
    private TextField UserNameLogin;
    @FXML
    private TextField PwdLogin;
	@FXML
	private Button LoginBtn;
	@FXML
	private Button RegstBtn;
    //Bar
	@FXML
	private Label HomeAlert;
	@FXML
	private Label DashboardAlert;
	@FXML
	private Button UserAlert;
	
	
	private File userDataFile;
	
	
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
	
	@FXML
    public void handleBtnLogin() {
		//Delete the space
		String userName = UserNameLogin.getText().trim();
        String password = PwdLogin.getText().trim();
        
    	//test
    	System.out.println("User name is " + userName);
    	System.out.println("Password is " + password);
    	
    	if (validPassword(userName, password)) {
    		Main.setUserStatus(new User(userName, password));
            System.out.println(userName + " success.");
            
            String uuid = getUUID(userName);
            if(uuid != null) {
            	//Set user name and uuid to UserData
            	UUID uuidFake = UUID.randomUUID();
            	//Keep 8 digit
            	String userID = uuidFake.toString().replace("-", "").substring(0, 8);
        		UserData.getData().setUserData(userName, userID);
            	
            	//jump to home page
                jumpToHomePage(userName);
            } else {
            	System.out.println(userName + " UUID not found.");
            }
        } else {
            showAlert("Fail to log in.", "Wrong password/username.");
        }
    }
	
	//C:\Users\******(adminName)\SmartDietPlanner\SDP_userdata.txt
	private String getUUID(String userName) {
		
		//Get admin
        String userHome = System.getProperty("user.home");
        //Read data
        userDataFile = new File(userHome, "SmartDietPlanner/SDP_userdata.txt");
        
        //If not exist
        if (!userDataFile.exists()) {
            System.out.println("User Data loaded fail.");
            return null;
        }
        
        //test
        System.out.println("Data: " + userDataFile);
		

	    try (BufferedReader br = new BufferedReader(new FileReader(userDataFile))) {
	        String line;
	        while ((line = br.readLine()) != null) {
	            String[] parts = line.split(",");
	            if (parts.length == 2 && parts[0].trim().equals(userName)) {
	                return parts[1].trim();  //uuid
	            }
	        }
	    } catch (IOException e) {
	    	System.err.println("Err when reading: " + e.getMessage());
	        e.printStackTrace();
	    }
	       
	    System.out.println("User not found: " + userName);
	    return null;
	}
	
	
	
	
	
	private boolean validPassword(String userName, String password) {
        File dataFile = Main.getUserDataFile();  //get user data
        try (BufferedReader reader = new BufferedReader(new FileReader(dataFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] userData = line.split(",");
                if (userData.length >= 2) {
                    String storedUserName = userData[0];
                    String storedPassword = userData[1];
                    if (storedUserName.equals(userName) && storedPassword.equals(password)) {
                        return true;  //compare success
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            showAlert("Fail to open.", "CANNOT load the User Data.");
        }
        return false;  //wrong password
    }
	
	@FXML
    public void switchToSigninPage() {
		try {
	        FXMLLoader loader = new FXMLLoader(getClass().getResource("/smartdietplanner/view/Register.fxml"));
	        Parent loginPage = loader.load();

	        Stage stage = (Stage) UserNameLogin.getScene().getWindow();
	        stage.setScene(new Scene(loginPage)); 
	        stage.setTitle("Login"); 
	        stage.show(); 
	    } catch (IOException e) {
	        e.printStackTrace();
	        showAlert("Fail to open.", "CANNOT load the Sign-in page.");
	    }
    }
	

	
	private void showLoginAlert() {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Alert");
        alert.setHeaderText(null);
        alert.setContentText("Plz login or register in ur account.");
        alert.showAndWait();
    }
	
	//public alert
	//alert
	private void showAlert(String title, String UserNameMsg) {
		Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(UserNameMsg);
        alert.showAndWait();
	}
	
	//Jump to home page (when success)
	private void jumpToHomePage(String userName) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/smartdietplanner/view/Goal.fxml"));
            Parent root = loader.load();
            
            //get the controller in index
//            IndexController indexController =loader.getController();
//            indexController.setWelcomeUser(userName);
            
            
            Stage stage = (Stage) UserNameLogin.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Goal");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            showAlert("Fail.", "CANNOT load the goal page.");
        }
    }
	
}




/*
 *  Home(menu)  #handleToHome
 *  Dashboard(menu)  #handleToDashboard
 *  UserAlert  #handleToUser
 *  
 *  UserNameLogin
 *  PwdLogin
 *  
 *  LoginBtn  #handleBtnLogin
 *  RegstBtn  #handleBtnReg
 *  
 */
