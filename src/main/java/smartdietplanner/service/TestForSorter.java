package smartdietplanner.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import smartdietplanner.model.Food;

class TestForSorter {
	@Test
	public void testSortByName() {
		ArrayList<Food> foodList = new ArrayList<>();
		// Food:  name,  calories,  protein,  carbs,  fat
		Food foodA = new Food("A", 1.0, 0.6, 2.2, 6.3);
		Food foodB = new Food("B", 3.0, 0.5, 0.2, 5.3);
		Food foodC = new Food("C", 2.0, 0.7, 1.2, 4.3);
		foodList.add(foodA);
		foodList.add(foodB);
		foodList.add(foodC);
		
		// Sorter:  name,  calories,  protein,  carbs,  fat,  reverse, foodList
		Sorter sorter = new Sorter(true, false, false, false, false, false, foodList);
		String expectedName1 = "A";
		String actualName1 = sorter.getSortedFoodList().get(0).getName();
		assertEquals(expectedName1, actualName1);
		String expectedName2 = "B";
		String actualName2 = sorter.getSortedFoodList().get(1).getName();
		assertEquals(expectedName2, actualName2);
		String expectedName3 = "C";
		String actualName3 = sorter.getSortedFoodList().get(2).getName();
		assertEquals(expectedName3, actualName3);
	}
	@Test
	public void testSortByCalories() {
		ArrayList<Food> foodList = new ArrayList<>();
		// Food:  name,  calories,  protein,  carbs,  fat
		Food foodA = new Food("A", 1.0, 0.6, 2.2, 6.3);
		Food foodB = new Food("B", 3.0, 0.5, 0.2, 5.3);
		Food foodC = new Food("C", 2.0, 0.7, 1.2, 4.3);
		foodList.add(foodA);
		foodList.add(foodB);
		foodList.add(foodC);
		
		// Sorter:  name,  calories,  protein,  carbs,  fat,  reverse, foodList
		Sorter sorter = new Sorter(false, true, false, false, false, false, foodList);
		String expectedName1 = "A";
		String actualName1 = sorter.getSortedFoodList().get(0).getName();
		assertEquals(expectedName1, actualName1);
		String expectedName2 = "C";
		String actualName2 = sorter.getSortedFoodList().get(1).getName();
		assertEquals(expectedName2, actualName2);
		String expectedName3 = "B";
		String actualName3 = sorter.getSortedFoodList().get(2).getName();
		assertEquals(expectedName3, actualName3);
	}
	@Test
	public void testSortByProtein() {
		ArrayList<Food> foodList = new ArrayList<>();
		// Food:  name,  calories,  protein,  carbs,  fat
		Food foodA = new Food("A", 1.0, 0.6, 2.2, 6.3);
		Food foodB = new Food("B", 3.0, 0.5, 0.2, 5.3);
		Food foodC = new Food("C", 2.0, 0.7, 1.2, 4.3);
		foodList.add(foodA);
		foodList.add(foodB);
		foodList.add(foodC);
		
		// Sorter:  name,  calories,  protein,  carbs,  fat,  reverse, foodList
		Sorter sorter = new Sorter(false, false, true, false, false, false, foodList);
		String expectedName1 = "B";
		String actualName1 = sorter.getSortedFoodList().get(0).getName();
		assertEquals(expectedName1, actualName1);
		String expectedName2 = "A";
		String actualName2 = sorter.getSortedFoodList().get(1).getName();
		assertEquals(expectedName2, actualName2);
		String expectedName3 = "C";
		String actualName3 = sorter.getSortedFoodList().get(2).getName();
		assertEquals(expectedName3, actualName3);
	}
	@Test
	public void testSortByCarb() {
		ArrayList<Food> foodList = new ArrayList<>();
		// Food:  name,  calories,  protein,  carbs,  fat
		Food foodA = new Food("A", 1.0, 0.6, 2.2, 6.3);
		Food foodB = new Food("B", 3.0, 0.5, 0.2, 5.3);
		Food foodC = new Food("C", 2.0, 0.7, 1.2, 4.3);
		foodList.add(foodA);
		foodList.add(foodB);
		foodList.add(foodC);
		
		// Sorter:  name,  calories,  protein,  carbs,  fat,  reverse, foodList
		Sorter sorter = new Sorter(false, false, false, true, false, false, foodList);
		String expectedName1 = "B";
		String actualName1 = sorter.getSortedFoodList().get(0).getName();
		assertEquals(expectedName1, actualName1);
		String expectedName2 = "C";
		String actualName2 = sorter.getSortedFoodList().get(1).getName();
		assertEquals(expectedName2, actualName2);
		String expectedName3 = "A";
		String actualName3 = sorter.getSortedFoodList().get(2).getName();
		assertEquals(expectedName3, actualName3);
	}
	@Test
	public void testSortByFat() {
		ArrayList<Food> foodList = new ArrayList<>();
		// Food:  name,  calories,  protein,  carbs,  fat
		Food foodA = new Food("A", 1.0, 0.6, 2.2, 6.3);
		Food foodB = new Food("B", 3.0, 0.5, 0.2, 5.3);
		Food foodC = new Food("C", 2.0, 0.7, 1.2, 4.3);
		foodList.add(foodA);
		foodList.add(foodB);
		foodList.add(foodC);
		
		// Sorter:  name,  calories,  protein,  carbs,  fat,  reverse, foodList
		Sorter sorter = new Sorter(false, false, false, false, true, false, foodList);
		String expectedName1 = "C";
		String actualName1 = sorter.getSortedFoodList().get(0).getName();
		assertEquals(expectedName1, actualName1);
		String expectedName2 = "B";
		String actualName2 = sorter.getSortedFoodList().get(1).getName();
		assertEquals(expectedName2, actualName2);
		String expectedName3 = "A";
		String actualName3 = sorter.getSortedFoodList().get(2).getName();
		assertEquals(expectedName3, actualName3);
	}
	@Test
	public void testSortByNameReverse() {
		ArrayList<Food> foodList = new ArrayList<>();
		// Food:  name,  calories,  protein,  carbs,  fat
		Food foodA = new Food("A", 1.0, 0.6, 2.2, 6.3);
		Food foodB = new Food("B", 3.0, 0.5, 0.2, 5.3);
		Food foodC = new Food("C", 2.0, 0.7, 1.2, 4.3);
		foodList.add(foodA);
		foodList.add(foodB);
		foodList.add(foodC);
		
		// Sorter:  name,  calories,  protein,  carbs,  fat,  reverse, foodList
		Sorter sorter = new Sorter(true, false, false, false, false, true, foodList);
		String expectedName1 = "C";
		String actualName1 = sorter.getSortedFoodList().get(0).getName();
		assertEquals(expectedName1, actualName1);
		String expectedName2 = "B";
		String actualName2 = sorter.getSortedFoodList().get(1).getName();
		assertEquals(expectedName2, actualName2);
		String expectedName3 = "A";
		String actualName3 = sorter.getSortedFoodList().get(2).getName();
		assertEquals(expectedName3, actualName3);
	}

}
