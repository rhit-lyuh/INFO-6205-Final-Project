import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import smartdietplanner.model.Food;
import smartdietplanner.model.MealPlan;
import smartdietplanner.service.UndoManager;

class TestForUndoManager {

	@Test
	public void testUnndoADD() {
		ArrayList<MealPlan> mpList = new ArrayList<>();
		UndoManager um = new UndoManager(mpList);
		// Food:  name,  calories,  protein,  carbs,  fat
		Food foodA = new Food("A", 1.0, 0.6, 2.2, 6.3);
		Food foodB = new Food("B", 3.0, 0.5, 0.2, 5.3);
		
		MealPlan mp1 = new MealPlan();
		mp1.addFood(foodA);
		
		MealPlan mp2 = new MealPlan();
		mp2.addFood(foodB);
		
		mpList.add(mp1);
		um.saveActionMP("ADD", mp1);
		assertEquals(1, mpList.size());
		
		mpList.add(mp2);
		um.saveActionMP("ADD", mp2);
		assertEquals(2, mpList.size());
		
		mpList = um.undoActionMP();
		assertEquals(1, mpList.size());
		assertEquals(mp1, mpList.get(0));
	}
	
	@Test
	public void testUnndoDELETE() {
		ArrayList<MealPlan> mpList = new ArrayList<>();
		UndoManager um = new UndoManager(mpList);
		// Food:  name,  calories,  protein,  carbs,  fat
		Food foodA = new Food("A", 1.0, 0.6, 2.2, 6.3);
		Food foodB = new Food("B", 3.0, 0.5, 0.2, 5.3);
		Food foodC = new Food("C", 2.0, 0.7, 1.2, 4.3);
		
		MealPlan mp1 = new MealPlan();
		mp1.addFood(foodA);
		
		MealPlan mp2 = new MealPlan();
		mp2.addFood(foodB);
		
		MealPlan mp3 = new MealPlan();
		mp3.addFood(foodC);
		
		mpList.add(mp1);
		um.saveActionMP("ADD", mp1);
		assertEquals(1, mpList.size());
		
		mpList.add(mp2);
		um.saveActionMP("ADD", mp2);
		assertEquals(2, mpList.size());
		
		mpList.add(mp3);
		um.saveActionMP("ADD", mp3);
		assertEquals(3, mpList.size());
		
		mpList.remove(2);
		um.saveActionMP("DELETE", mp3);
		assertEquals(2, mpList.size());
		
		mpList = um.undoActionMP();
		assertEquals(3, mpList.size());
	}
	@Test
	public void testUnndoMultiple() {
		ArrayList<MealPlan> mpList = new ArrayList<>();
		UndoManager um = new UndoManager(mpList);
		// Food:  name,  calories,  protein,  carbs,  fat
		Food foodA = new Food("A", 1.0, 0.6, 2.2, 6.3);
		Food foodB = new Food("B", 3.0, 0.5, 0.2, 5.3);
		Food foodC = new Food("C", 2.0, 0.7, 1.2, 4.3);
		
		MealPlan mp1 = new MealPlan();
		mp1.addFood(foodA);
		
		MealPlan mp2 = new MealPlan();
		mp2.addFood(foodB);
		
		MealPlan mp3 = new MealPlan();
		mp3.addFood(foodC);
		
		mpList.add(mp1);
		um.saveActionMP("ADD", mp1);
		assertEquals(1, mpList.size());
		
		mpList.add(mp2);
		um.saveActionMP("ADD", mp2);
		assertEquals(2, mpList.size());
		
		mpList.add(mp3);
		um.saveActionMP("ADD", mp3);
		assertEquals(3, mpList.size());
		
		mpList.remove(2);
		um.saveActionMP("DELETE", mp3);
		assertEquals(2, mpList.size());
		
		mpList = um.undoActionMP();
		assertEquals(3, mpList.size());
		
		mpList = um.undoActionMP();
		assertEquals(2, mpList.size());
	}

}
