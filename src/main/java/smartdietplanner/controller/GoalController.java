package smartdietplanner.controller;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import smartdietplanner.model.MealPlan;
import smartdietplanner.model.NutritionGoal;

public class GoalController {

    // Navigation Bar
    @FXML private Label HomeNav;
    @FXML private Label DashboardNav;
    @FXML private Button UserNav;
    @FXML private Button FoodNav;

    // Input fields
    @FXML private TextField currentWeightField;
    @FXML private TextField goalWeightField;
    @FXML private TextField dietDaysField;

    // Handlers for navigation
    @FXML
    public void handleToHome() {
        showAlert("Alert", "This is Home Page.");
    }

    @FXML
    public void handleToDashboard() {
        navigateTo("/smartdietplanner/view/Dashboard.fxml", "Dashboard");
    }

    @FXML
    public void handleToUser() {
//        navigateTo("/smartdietplanner/view/User.fxml", "User");

		try {
	        FXMLLoader loader = new FXMLLoader(getClass().getResource("/smartdietplanner/view/User.fxml"));
	        Parent userPage = loader.load();

	        Stage stage = (Stage) UserNav.getScene().getWindow();
	        
	        stage.setScene(new Scene(userPage));
	        stage.setTitle("User");
	        stage.show();
	    } catch (IOException e) {
	        e.printStackTrace();
	        showAlert("Fail to open.", "CANNOT load the User page." + e.getMessage());
	    }

    }

    @FXML
    public void handleToFood() {
        navigateTo("/smartdietplanner/view/Foodlist.fxml", "Food List");
    }

    @FXML
    public void handleGeneratePlan() {
        try {
            double currentWeight = Double.parseDouble(currentWeightField.getText());
            double goalWeight = Double.parseDouble(goalWeightField.getText());
            int dietDays = Integer.parseInt(dietDaysField.getText());

            // Create the nutrition goal
            NutritionGoal goal = new NutritionGoal(currentWeight, goalWeight, dietDays);

            // Initialize an empty MealPlan (to be manually added by the user later)
            MealPlan mealPlan = new MealPlan();

            // Navigate to the Plan page and pass data
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/smartdietplanner/view/Plan.fxml"));
            Parent root = loader.load();


            smartdietplanner.controller.PlanController controller = loader.getController();
            controller.setNutritionGoal(goal);
            controller.setMealPlan(mealPlan);

            Stage stage = (Stage) currentWeightField.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Your Smart Diet Plan");
            stage.show();

        } catch (NumberFormatException e) {
            showAlert("Input Error", "Please enter valid numbers for weight and days.");
        } catch (Exception e) {
            e.printStackTrace();
            showAlert("Error", "Something went wrong while generating the plan.");
        }
    }

    private void navigateTo(String fxmlPath, String title) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
            Parent page = loader.load();

            Stage stage = (Stage) HomeNav.getScene().getWindow(); 
            stage.setScene(new Scene(page));
            stage.setTitle(title);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
            showAlert("Navigation Error", "Failed to open " + title + " page.");
        }
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
