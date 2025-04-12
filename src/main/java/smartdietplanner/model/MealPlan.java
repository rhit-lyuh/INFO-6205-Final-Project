package smartdietplanner.model;

import java.util.LinkedHashMap;
import java.util.Map;

public class MealPlan implements MealPlanBag {

    private static MealPlan instance;

    // Map<Food, weightInGrams>
    private Map<Food, Integer> foodItems = new LinkedHashMap<>();

    public static MealPlan getInstance() {
        if (instance == null) {
            instance = new MealPlan();
        }
        return instance;
    }

    @Override
    public void addFood(Food food, int grams) {
        if (food == null || grams <= 0) {
            throw new IllegalArgumentException("Food cannot be null and weight must be positive.");
        }
        foodItems.put(food, grams);
    }

    @Override
    public void removeFood(Food food) {
        if (food == null) {
            throw new IllegalArgumentException("Food cannot be null.");
        }
        foodItems.remove(food);
    }

    @Override
    public void increaseWeight(Food food, int grams) {
        if (food == null || grams <= 0) {
            throw new IllegalArgumentException("Food cannot be null and weight must be positive.");
        }
        foodItems.put(food, foodItems.getOrDefault(food, 0) + grams);
    }

    @Override
    public void decreaseWeight(Food food, int grams) {
        if (food == null || grams <= 0) {
            throw new IllegalArgumentException("Food cannot be null and weight must be positive.");
        }
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

    @Override
    public double getTotalCalories() {
        return foodItems.entrySet().stream()
            .mapToDouble(e -> e.getKey().getCalories() * e.getValue() / 100.0)
            .sum();
    }

    @Override
    public double getTotalProtein() {
        return foodItems.entrySet().stream()
            .mapToDouble(e -> e.getKey().getProtein() * e.getValue() / 100.0)
            .sum();
    }

    @Override
    public double getTotalCarbs() {
        return foodItems.entrySet().stream()
            .mapToDouble(e -> e.getKey().getCarbs() * e.getValue() / 100.0)
            .sum();
    }

    @Override
    public double getTotalFat() {
        return foodItems.entrySet().stream()
            .mapToDouble(e -> e.getKey().getFat() * e.getValue() / 100.0)
            .sum();
    }

    @Override
    public Map<Food, Integer> getFoodItems() {
        return new LinkedHashMap<>(foodItems);
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
