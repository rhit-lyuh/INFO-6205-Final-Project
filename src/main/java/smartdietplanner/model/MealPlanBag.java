package smartdietplanner.model;

import java.util.Map;

/**
 * MealPlanBag defines an ADT for managing a meal plan.
 * It supports adding, removing, and modifying food items, as well as calculating total nutrients.
 */
public interface MealPlanBag {

    /**
     * Add a food item with the specified weight (in grams) to the meal plan.
     * If the item already exists, it will be overwritten.
     *
     * @param food  the food item to add
     * @param grams the weight of the food in grams 
     */
    void addFood(Food food, int grams);

    /**
     * Remove a food item from the meal plan.
     *
     * @param food the food item to remove
     */
    void removeFood(Food food);

    /**
     * Increase the weight of an existing food item in the meal plan.
     * If the item does not exist, it will be added.
     *
     * @param food  the food item
     * @param grams the amount to increase (must be positive)
     */
    void increaseWeight(Food food, int grams);

    /**
     * Decrease the weight of an existing food item in the meal plan.
     * If the resulting weight is zero or negative, the item will be removed.
     *
     * @param food  the food item
     * @param grams the amount to decrease (must be positive)
     */
    void decreaseWeight(Food food, int grams);

    /**
     * Calculate the total calories of all food items in the meal plan.
     *
     * @return the total calories
     */
    double getTotalCalories();

    /**
     * Calculate the total protein (in grams) of all food items in the meal plan.
     *
     * @return the total protein
     */
    double getTotalProtein();

    /**
     * Calculate the total carbohydrates (in grams) of all food items in the meal plan.
     *
     * @return the total carbs
     */
    double getTotalCarbs();

    /**
     * Calculate the total fat (in grams) of all food items in the meal plan.
     *
     * @return the total fat
     */
    double getTotalFat();

    /**
     * Get a map of all food items and their corresponding weights in the meal plan.
     *
     * @return a map of Food to weight in grams
     */
    Map<Food, Integer> getFoodItems();
}
