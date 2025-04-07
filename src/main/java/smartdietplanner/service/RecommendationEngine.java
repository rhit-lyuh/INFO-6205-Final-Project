package smartdietplanner.service;

import java.util.ArrayList;

import smartdietplanner.model.Food;
import smartdietplanner.model.MealPlan;
import smartdietplanner.model.NutritionGoal;

public class RecommendationEngine {
	private NutritionGoal ng;
	private ArrayList<Food> foodList;
	private ArrayList<MealPlan> mealPlanList = new ArrayList<>();
	private ArrayList<MealPlan> combinationResult = new ArrayList<>();
	public RecommendationEngine(NutritionGoal ng, ArrayList<Food> foodList) {
		this.ng = ng;
		this.foodList = foodList;
		generateMealPlan();
	}
	public ArrayList<MealPlan> getMealPlan() {
		return this.mealPlanList;
	}
	private void generateMealPlan() {
		for (int i = 0; i < this.foodList.size(); i++) {
			MealPlan current = new MealPlan();
        	Food food = foodList.get(i);
            current.addFood(food); // Include element
            generateFoodCombination(i + 1, current); // Recurse
        }
        for (int i = 0; i< this.combinationResult.size(); i++) {
        	MealPlan mp = this.combinationResult.get(i);
        	if(this.mealPlanList.contains(mp)) {
        		continue;
        	}
        	double totalCalories = mp.getTotalCalories();
        	double totalFat= mp.getTotalFat();
        	double totalProtein = mp.getTotalProtein();
        	double totalCarbs = mp.getTotalCarbs();
        	if(totalCalories <= this.ng.getTargetCalories() && totalFat <= this.ng.getTargetFat() && totalProtein <= this.ng.getTargetProtein() && 
        			totalCarbs <= this.ng.getTargetCarbs()) {
        		this.mealPlanList.add(mp);
        	}
        }
	}
    private void generateFoodCombination(int start, MealPlan current) {
        // Add current subset to result
    	if(this.combinationResult.contains(current)) {
    		return;
    	}
        this.combinationResult.add(current);
        // Try including each element starting from index
        for (int i = start; i < this.foodList.size(); i++) {
        	Food food = this.foodList.get(i);
            current.addFood(food); // Include element
            generateFoodCombination(i + 1, current); // Recurse
            current.removeFood(food);
        }
    }
}
