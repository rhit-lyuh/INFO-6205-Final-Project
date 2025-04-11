package smartdietplanner.model;

import java.util.LinkedHashMap;
import java.util.Map;

public class MealPlan {

    // Map<Food, weightInGrams>
    private Map<Food, Integer> foodItems = new LinkedHashMap<>();

    public void addFood(Food food, int grams) {
        foodItems.put(food, grams);
    }

    public void removeFood(Food food) {
        foodItems.remove(food);
    }
    
    public void increaseWeight(Food food, int grams) {
        foodItems.put(food, foodItems.getOrDefault(food, 0) + grams);
    }

    public void decreaseWeight(Food food, int grams) {
        if (foodItems.containsKey(food)) {
            int current = foodItems.get(food);
            int updated = current - grams;
            if (updated > 0) {
                foodItems.put(food, updated);
            } else {
                foodItems.remove(food);
            }
        }
    }


    public double getTotalCalories() {
        return foodItems.entrySet().stream()
            .mapToDouble(e -> e.getKey().getCalories() * e.getValue() / 100.0)
            .sum();
    }

    public double getTotalProtein() {
        return foodItems.entrySet().stream()
            .mapToDouble(e -> e.getKey().getProtein() * e.getValue() / 100.0)
            .sum();
    }

    public double getTotalCarbs() {
        return foodItems.entrySet().stream()
            .mapToDouble(e -> e.getKey().getCarbs() * e.getValue() / 100.0)
            .sum();
    }

    public double getTotalFat() {
        return foodItems.entrySet().stream()
            .mapToDouble(e -> e.getKey().getFat() * e.getValue() / 100.0)
            .sum();
    }

    public Map<Food, Integer> getFoodItems() {
        return foodItems;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        foodItems.forEach((food, grams) -> {
            sb.append(String.format("%s - %dg\n", food.getName(), grams));
        });
        sb.append(String.format("Calories: %.1f kcal, Protein: %.1f g, Carbs: %.1f g, Fat: %.1f g",
                getTotalCalories(), getTotalProtein(), getTotalCarbs(), getTotalFat()));
        return sb.toString();
    }
}

