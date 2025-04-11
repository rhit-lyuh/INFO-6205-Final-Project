package smartdietplanner.controller;

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

import java.io.IOException;

public class PlanController {

    @FXML private Label goalLabel;
    @FXML private TableView<Food> mealTable;
    @FXML private TableColumn<Food, String> nameColumn;
    @FXML private TableColumn<Food, Integer> weightColumn;
    @FXML private Label summaryLabel;
    @FXML private Button addFoodButton;
    @FXML private Button backButton;

    private MealPlan mealPlan = new MealPlan();
    private NutritionGoal goal;
    private final ObservableList<Food> foodList = FXCollections.observableArrayList();

    public void setNutritionGoal(NutritionGoal goal) {
        this.goal = goal;
        updateGoalLabel();
        updateMealPlanView();
    }

    public void setMealPlan(MealPlan mealPlan) {
        this.mealPlan = mealPlan;
        updateMealPlanView();
    }
    
    public NutritionGoal getNutritionGoal() {
        return goal;
    }


    private void updateGoalLabel() {
        if (goal != null) {
            String text = String.format("Target: %.0f kcal | %.0f g protein | %.0f g carbs | %.0f g fat",
                    goal.getTargetCalories(), goal.getTargetProtein(), goal.getTargetCarbs(), goal.getTargetFat());
            goalLabel.setText(text);
        }
    }

    public void updateMealPlanView() {
        foodList.setAll(mealPlan.getFoodItems().keySet());
        mealTable.setItems(foodList);

        String summary = String.format("Total: %.1f kcal | %.1f g protein | %.1f g carbs | %.1f g fat",
                mealPlan.getTotalCalories(), mealPlan.getTotalProtein(),
                mealPlan.getTotalCarbs(), mealPlan.getTotalFat());

        if (goal != null && mealPlan.getTotalCalories() > goal.getTargetCalories()) {
            summary += "\n⚠Total calories exceed your target!";
        }

        summaryLabel.setText(summary);
    }

    @FXML
    private void initialize() {
        nameColumn.setCellValueFactory(cell -> new javafx.beans.property.SimpleStringProperty(cell.getValue().getName()));
        weightColumn.setCellValueFactory(cell -> new javafx.beans.property.SimpleIntegerProperty(
                mealPlan.getFoodItems().getOrDefault(cell.getValue(), 0)).asObject());

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

    public void updateMealPlanViewAfterAdd() {
        updateMealPlanView(); // Called after food is added
    }

    private void showAlert(String title, String msg) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(msg);
        alert.showAndWait();
    }
}

