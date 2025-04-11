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
import smartdietplanner.model.NutritionGoal;
import smartdietplanner.model.UserData;

public class DashboardController {

	
    //Bar
	@FXML
	private Label HomeNav;
	@FXML
	private Label DashboardNav;
	@FXML
	private Button UserNav;
	
	//Btns
	@FXML
	private Button detailNav1;
	@FXML
	private Button detailNav2;
	@FXML
	private Button detailNav3;
	
	
	//Data
	@FXML
	private Label Carbo;
	@FXML
	private Label Protein;
	@FXML
	private Label Fat;
	
	private NutritionGoal goal;
	
	//Set Data
	@FXML
	public void initialize() {
		
		
	    //Content
//		String CarboText = String.format("Carbohydrates: %.1f g", goal.getTargetCarbs());
//	    String ProteinText = String.format("Proteins: %.1f g", goal.getTargetProtein());
//	    String FatText = String.format("Fats: %.1f g", goal.getTargetFat());
	    String CarboText = "Carbohydrates: 290 g";
	    String ProteinText = "Proteins: 218 g";
	    String FatText = "Fats: 97 g";
	    
	    //test
	    System.out.println(CarboText);
	    System.out.println(ProteinText);
	    System.out.println(FatText);
	    
		//Set Dashboard
	    Carbo.setText(CarboText);
	    Protein.setText(ProteinText);
	    Fat.setText(FatText);


	}

	
	
	//To detail
	@FXML
	public void handleToDetail() {
		System.out.println("clicked");
		try {
	        FXMLLoader loader = new FXMLLoader(getClass().getResource("/smartdietplanner/view/PlanDetail.fxml"));
	        Parent detailPage = loader.load();

	        Stage stage = (Stage) HomeNav.getScene().getWindow();
	        stage.setScene(new Scene(detailPage));
	        stage.setTitle("Plan Detail");
	        stage.show();
	    } catch (IOException e) {
	        e.printStackTrace();
	        showAlert("Fail to open.", "CANNOT load the PlanDetail page.");
	    }
    }
	
	
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
