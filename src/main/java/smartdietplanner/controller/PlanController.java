package smartdietplanner.controller;

import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import smartdietplanner.model.Food;
import smartdietplanner.model.MealPlan;
import smartdietplanner.model.NutritionGoal;

/**
 * Controller for the Plan page, which allows users to view and manage their meal plan
 * after setting their nutrition goal.
 */
public class PlanController {

    // Top navigation bar components
    @FXML private Label HomeNav;
    @FXML private Label DashboardNav;
    @FXML private Button UserNav;

    // Plan page UI components
    @FXML private Label goalLabel;
    @FXML private TableView<Food> mealTable;
    @FXML private TableColumn<Food, String> nameColumn;
    @FXML private TableColumn<Food, Integer> weightColumn;
    @FXML private Label summaryLabel;
    @FXML private Button addFoodButton;
    @FXML private Button backButton;

    // Data variables
    private MealPlan mealPlan = new MealPlan();
    private NutritionGoal goal;
    private final ObservableList<Food> foodList = FXCollections.observableArrayList();

    /**Navigation Methods (Top Bar)**/

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

    /**Logic for Meal Planning**/

    public void setNutritionGoal(NutritionGoal goal) {
        this.goal = goal;
        updateGoalLabel();
        updateMealPlanView();
    }

    public NutritionGoal getNutritionGoal() {
        return goal;
    }

    public void setMealPlan(MealPlan mealPlan) {
        this.mealPlan = mealPlan;
        updateMealPlanView();
    }

    private void updateGoalLabel() {
        if (goal != null) {
            String text = String.format("Target: %.0f kcal | %.0f g protein | %.0f g carbs | %.0f g fat",
                    goal.getTargetCalories(), goal.getTargetProtein(),
                    goal.getTargetCarbs(), goal.getTargetFat());
            goalLabel.setText(text);
        }
    }

    public void updateMealPlanView() {
        // Refresh the table with food items
        foodList.setAll(mealPlan.getFoodItems().keySet());
        mealTable.setItems(foodList);

        // Display nutrition summary
        String summary = String.format("Total: %.1f kcal | %.1f g protein | %.1f g carbs | %.1f g fat",
                mealPlan.getTotalCalories(), mealPlan.getTotalProtein(),
                mealPlan.getTotalCarbs(), mealPlan.getTotalFat());

        if (goal != null && mealPlan.getTotalCalories() > goal.getTargetCalories()) {
            summary += "\n⚠ Total calories exceed your target!";
        }

        summaryLabel.setText(summary);
    }

    /**Table Initialization and Row Events**/

    @FXML
    private void initialize() {
        // Setup table columns
        nameColumn.setCellValueFactory(cell -> new javafx.beans.property.SimpleStringProperty(cell.getValue().getName()));
        weightColumn.setCellValueFactory(cell -> new javafx.beans.property.SimpleIntegerProperty(
                mealPlan.getFoodItems().getOrDefault(cell.getValue(), 0)).asObject());

        // Double-click row to edit food weight
        mealTable.setRowFactory(tv -> {
            TableRow<Food> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (!row.isEmpty() && event.getClickCount() == 2) {
                    Food selected = row.getItem();
                    TextInputDialog dialog = new TextInputDialog(String.valueOf(mealPlan.getFoodItems().getOrDefault(selected, 100)));
                    dialog.setTitle("Modify Weight");
                    dialog.setHeaderText("Update weight for " + selected.getName());
                    dialog.setContentText("Weight (grams):");

                    dialog.showAndWait().ifPresent(value -> {
                        try {
                            int grams = Integer.parseInt(value);
                            if (grams <= 0) {
                                mealPlan.removeFood(selected);
                            } else {
                                mealPlan.addFood(selected, grams);
                            }
                            updateMealPlanView();
                        } catch (NumberFormatException e) {
                            showAlert("Invalid Input", "Please enter a valid number.");
                        }
                    });
                }
            });
            return row;
        });
    }

    /**Navigation: Add Food & Back**/

    @FXML
    public void handleAddFood() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/smartdietplanner/view/Foodlist.fxml"));
            Parent foodListPage = loader.load();

            FoodlistController controller = loader.getController();
            controller.setMealPlan(mealPlan);
            controller.setPlanController(this);

            Stage stage = (Stage) addFoodButton.getScene().getWindow();
            stage.setScene(new Scene(foodListPage));
            stage.setTitle("Select Food");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            showAlert("Navigation Error", "Unable to open food list.");
        }
    }

    @FXML
    public void handleBack() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/smartdietplanner/view/Goal.fxml"));
            Parent goalPage = loader.load();
            Stage stage = (Stage) backButton.getScene().getWindow();
            stage.setScene(new Scene(goalPage));
            stage.setTitle("Set Your Goal");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            showAlert("Navigation Error", "Unable to return to goal page.");
        }
    }

    // Used by FoodlistController after food is added
    public void updateMealPlanViewAfterAdd() {
        updateMealPlanView();
    }

    // Utility method to show alert dialog
    private void showAlert(String title, String msg) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(msg);
        alert.showAndWait();
    }
}
