package smartdietplanner.util;

import java.util.List;

import smartdietplanner.model.Food;

public class FileIOTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Food> foods = FileIO.loadFoodDatabase();
		for (Food food : foods) {
		    System.out.println(food);
		}


	}

}
