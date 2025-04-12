package smartdietplanner.util;

import smartdietplanner.model.Food;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class FileIO {

    public static List<Food> loadFoodDatabase() {
        List<Food> foodList = new ArrayList<>();

        try {
        	InputStream is = FileIO.class.getClassLoader().getResourceAsStream("smartdietplanner/foodDatabase.csv");

            BufferedReader reader = new BufferedReader(new InputStreamReader(is));

            String line;
            boolean firstLine = true;

            while ((line = reader.readLine()) != null) {
                if (firstLine) { // Skip the header
                    firstLine = false;
                    continue;
                }

                String[] parts = line.split(",");

                if (parts.length == 5) {
                    String name = parts[0];
                    double calories = Double.parseDouble(parts[1]);
                    double protein = Double.parseDouble(parts[2]);
                    double carbs = Double.parseDouble(parts[3]);
                    double fat = Double.parseDouble(parts[4]);

                    Food food = new Food(name, calories, protein, carbs, fat);
                    foodList.add(food);
                }
            }

            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return foodList;
    }
}
