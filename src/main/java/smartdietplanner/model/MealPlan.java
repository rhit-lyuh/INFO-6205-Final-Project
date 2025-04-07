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
    	this.meals.add(food);
        this.totalCalories += Math.round( food.getCalories()*100)/100;
        this.totalProtein += Math.round( food.getProtein()*100)/100;
        this.totalCarbs += Math.round( food.getCarbs()*100)/100;
        this.totalFat += Math.round( food.getFat()*100)/100;
    }

    /**
     * Removes a Food object from the meal plan and updates the total nutritional values.
     *
     * @param food the Food object to remove
     */
    public void removeFood(Food food) {
        if(this.meals.remove(food)) {
        	this.totalCalories -=Math.round( food.getCalories()*100)/100;
        	this.totalProtein -= Math.round( food.getProtein()*100)/100;
        	this.totalCarbs -= Math.round( food.getCarbs()*100)/100;
        	this.totalFat -= Math.round( food.getFat()*100)/100;
        }
    }

    //Getter and Setter
    public List<Food> getMeals() {
        return this.meals;
    }

    public void setMeals(List<Food> meals) {
        this.meals = meals;
    }

    public double getTotalCalories() {
        return  this.totalCalories;
    }

    public void setTotalCalories(double totalCalories) {
        this.totalCalories = totalCalories;
    }

    public double getTotalProtein() {
        return this.totalProtein;
    }

    public void setTotalProtein(double totalProtein) {
        this.totalProtein = totalProtein;
    }

    public double getTotalCarbs() {
        return this.totalCarbs;
    }

    public void setTotalCarbs(double totalCarbs) {
        this.totalCarbs = totalCarbs;
    }

    public double getTotalFat() {
        return this.totalFat;
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
