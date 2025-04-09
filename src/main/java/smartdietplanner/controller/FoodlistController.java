package smartdietplanner.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import smartdietplanner.model.Food;
import smartdietplanner.util.FileIO;

import java.io.IOException;
import java.util.List;

public class FoodlistController {
	
	//Bar
	@FXML
	private Label HomeNav;
	@FXML
	private Label DashboardNav;
	@FXML
	private Button UserNav;
	@FXML
	private Button FoodNav;
	
	
	//Table
    @FXML
    private TableView<Food> foodTable;

    @FXML
    private TableColumn<Food, String> nameColumn;

    @FXML
    private TableColumn<Food, Double> caloriesColumn;

    @FXML
    private TableColumn<Food, Double> proteinColumn;

    @FXML
    private TableColumn<Food, Double> carbsColumn;

    @FXML
    private TableColumn<Food, Double> fatColumn;
    
    @FXML
    private Button backButton;
    
    
    
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

	


    @FXML
    public void initialize() {
        // Bind columns to Food class properties
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        caloriesColumn.setCellValueFactory(new PropertyValueFactory<>("calories"));
        proteinColumn.setCellValueFactory(new PropertyValueFactory<>("protein"));
        carbsColumn.setCellValueFactory(new PropertyValueFactory<>("carbs"));
        fatColumn.setCellValueFactory(new PropertyValueFactory<>("fat"));

        // Load food data from file and display in table
        List<Food> foods = FileIO.loadFoodDatabase();
        ObservableList<Food> foodData = FXCollections.observableArrayList(foods);
        foodTable.setItems(foodData);
    }
    
    

    @FXML
    private void handleBack() {
        try {
        	
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/smartdietplanner/view/Goal.fxml"));
            Parent previousPage = loader.load();

            Stage stage = (Stage) backButton.getScene().getWindow();
            stage.setScene(new Scene(previousPage));
            stage.setTitle("Goal");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Navigation Error");
            alert.setHeaderText(null);
            alert.setContentText("Failed to go back to previous page.");
            alert.showAndWait();
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
