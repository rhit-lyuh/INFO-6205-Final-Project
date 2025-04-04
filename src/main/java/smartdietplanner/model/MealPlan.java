package smartdietplanner.model;

import java.util.ArrayList;
import java.util.List;

public class MealPlan {

    //A list of Food objects representing the meals in the meal plan.
    private List<Food> meals;
    private double totalCalories;
    private double totalProtein;
    private double totalCarbs;
    private double totalFat;

    //Constructor
    public MealPlan() {
        this.meals = new ArrayList<>();
        this.totalCalories = 0;
        this.totalProtein = 0;
        this.totalCarbs = 0;
        this.totalFat = 0;
    }

    /**
     * Adds a Food object to the meal plan and updates the total nutritional values.
     *
     * @param food the Food object to add
     */
    public void addFood(Food food) {
        meals.add(food);
        totalCalories += food.getCalories();
        totalProtein += food.getProtein();
        totalCarbs += food.getCarbs();
        totalFat += food.getFat();
    }

    /**
     * Removes a Food object from the meal plan and updates the total nutritional values.
     *
     * @param food the Food object to remove
     */
    public void removeFood(Food food) {
        if(meals.remove(food)) {
            totalCalories -= food.getCalories();
            totalProtein -= food.getProtein();
            totalCarbs -= food.getCarbs();
            totalFat -= food.getFat();
        }
    }

    //Getter and Setter
    public List<Food> getMeals() {
        return meals;
    }

    public void setMeals(List<Food> meals) {
        this.meals = meals;
    }

    public double getTotalCalories() {
        return totalCalories;
    }

    public void setTotalCalories(double totalCalories) {
        this.totalCalories = totalCalories;
    }

    public double getTotalProtein() {
        return totalProtein;
    }

    public void setTotalProtein(double totalProtein) {
        this.totalProtein = totalProtein;
    }

    public double getTotalCarbs() {
        return totalCarbs;
    }

    public void setTotalCarbs(double totalCarbs) {
        this.totalCarbs = totalCarbs;
    }

    public double getTotalFat() {
        return totalFat;
    }

    public void setTotalFat(double totalFat) {
        this.totalFat = totalFat;
    }

    @Override
    public String toString() {
        return "MealPlan{" +
                "meals=" + meals +
                ", totalCalories=" + totalCalories +
                ", totalProtein=" + totalProtein +
                ", totalCarbs=" + totalCarbs +
                ", totalFat=" + totalFat +
                '}';
    }
}
