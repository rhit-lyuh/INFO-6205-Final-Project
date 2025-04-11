package smartdietplanner.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import smartdietplanner.model.Food;
import smartdietplanner.model.MealPlan;
import smartdietplanner.util.FileIO;

import java.io.IOException;
import java.util.List;

public class FoodlistController {

    @FXML private TableView<Food> foodTable;
    @FXML private TableColumn<Food, String> nameColumn;
    @FXML private TableColumn<Food, Double> caloriesColumn;
    @FXML private TableColumn<Food, Double> proteinColumn;
    @FXML private TableColumn<Food, Double> carbsColumn;
    @FXML private TableColumn<Food, Double> fatColumn;
    @FXML private Button backButton;

    private MealPlan mealPlan;
    private PlanController planController;

    public void setMealPlan(MealPlan mealPlan) {
        this.mealPlan = mealPlan;
    }

    public void setPlanController(PlanController controller) {
        this.planController = controller;
    }

    @FXML
    public void initialize() {
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        caloriesColumn.setCellValueFactory(new PropertyValueFactory<>("calories"));
        proteinColumn.setCellValueFactory(new PropertyValueFactory<>("protein"));
        carbsColumn.setCellValueFactory(new PropertyValueFactory<>("carbs"));
        fatColumn.setCellValueFactory(new PropertyValueFactory<>("fat"));

        List<Food> foods = FileIO.loadFoodDatabase();
        ObservableList<Food> foodData = FXCollections.observableArrayList(foods);
        foodTable.setItems(foodData);

        foodTable.setRowFactory(tv -> {
            TableRow<Food> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (!row.isEmpty() && event.getClickCount() == 2) {
                    Food selectedFood = row.getItem();
                    addFoodToMealPlan(selectedFood);
                }
            });
            return row;
        });
    }

    private void addFoodToMealPlan(Food food) {
        TextInputDialog dialog = new TextInputDialog("100");
        dialog.setTitle("Add Food");
        dialog.setHeaderText("Enter weight in grams for " + food.getName());
        dialog.setContentText("Weight (grams):");

        dialog.showAndWait().ifPresent(input -> {
            try {
                int grams = Integer.parseInt(input);
                if (grams <= 0) throw new NumberFormatException();
                mealPlan.addFood(food, grams);
                showInfo("Added", food.getName() + " - " + grams + "g added.");
                if (planController != null) {
                    planController.updateMealPlanViewAfterAdd();
                }
            } catch (NumberFormatException e) {
                showError("Invalid Input", "Please enter a positive number.");
            }
        });
    }


    @FXML
    private void handleBack() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/smartdietplanner/view/Plan.fxml"));
            Parent planPage = loader.load();

            PlanController controller = loader.getController();
            controller.setMealPlan(mealPlan);
            controller.setNutritionGoal(planController.getNutritionGoal());  // ✅ 传回目标数据
            controller.updateMealPlanView(); // ✅ 确保界面更新

            Stage stage = (Stage) backButton.getScene().getWindow();
            stage.setScene(new Scene(planPage));
            stage.setTitle("Meal Plan");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            showError("Navigation Error", "Failed to go back to plan page.");
        }
    }


    private void showError(String title, String msg) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(msg);
        alert.showAndWait();
    }

    private void showInfo(String title, String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(msg);
        alert.showAndWait();
    }
}

