import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import smartdietplanner.model.Food;
import smartdietplanner.model.MealPlan;
import smartdietplanner.model.NutritionGoal;
import smartdietplanner.service.RecommendationEngine;

public class TestForRecommendationEngine {

	@Test
	public void testRecommendationEngine1() {
		ArrayList<Food> foodList = new ArrayList<>();
		// Food:  name,  calories,  protein,  carbs,  fat
		Food foodA = new Food("A", 1, 0.6, 2.2, 6.3);
		Food foodB = new Food("B", 3, 0.5, 0.2, 5.3);
		Food foodC = new Food("C", 2, 0.7, 1.2, 4.3);
		foodList.add(foodA);
		foodList.add(foodB);
		foodList.add(foodC);
//		NutritionGoal:  targetCalories,  targetProtein,  targetCarbs,  targetFat
		NutritionGoal ng = new NutritionGoal(1,0.6,2.2,6.3);
		
		RecommendationEngine re = new RecommendationEngine(ng, foodList);
		ArrayList<MealPlan>  actual = re.getMealPlan();
		assertEquals(1, actual.size());
	}
	
	@Test
	public void testRecommendationEngine2() {
		ArrayList<Food> foodList = new ArrayList<>();
		// Food:  name,  calories,  protein,  carbs,  fat
		Food foodA = new Food("A", 1.0, 0.6, 2.2, 6.3);
		Food foodB = new Food("B", 3.0, 0.5, 0.2, 5.3);
		Food foodC = new Food("C", 2.0, 0.7, 1.2, 4.3);
		foodList.add(foodA);
		foodList.add(foodB);
		foodList.add(foodC);
//		NutritionGoal:  targetCalories,  targetProtein,  targetCarbs,  targetFat
		NutritionGoal ng = new NutritionGoal(0.1,0.6,2.2,6.3);
		
		RecommendationEngine re = new RecommendationEngine(ng, foodList);
		ArrayList<MealPlan>  actual = re.getMealPlan();
		assertEquals(0, actual.size());
	}
	
	@Test
	public void testRecommendationEngine3() {
		ArrayList<Food> foodList = new ArrayList<>();
		// Food:  name,  calories,  protein,  carbs,  fat
		Food foodA = new Food("A", 1.0, 0.6, 2.2, 6.3);
		Food foodB = new Food("B", 3.0, 0.5, 0.2, 5.3);
		Food foodC = new Food("C", 2.0, 0.7, 1.2, 4.3);
		foodList.add(foodA);
		foodList.add(foodB);
		foodList.add(foodC);
//		NutritionGoal:  targetCalories,  targetProtein,  targetCarbs,  targetFat
		NutritionGoal ng = new NutritionGoal(3,1.4,4,11);
		RecommendationEngine re = new RecommendationEngine(ng, foodList);
		ArrayList<MealPlan>  actual = re.getMealPlan();
		assertEquals(3, actual.size());
	}

}
