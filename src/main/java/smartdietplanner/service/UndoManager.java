package smartdietplanner.service;

import java.util.ArrayList;
import java.util.Stack;
import smartdietplanner.model.MealPlan;

public class UndoManager {
	private Stack<String> mpStatus = new Stack<>();
	private Stack<MealPlan> mpTarget = new Stack<>();
	private ArrayList<MealPlan> mealPlanList;
	
	public UndoManager(ArrayList<MealPlan> mealPlanList) {
		this.mealPlanList = mealPlanList;
	}
	public void saveActionMP(String actionKey, MealPlan mp) {
		this.mpStatus.push(actionKey);
		this.mpTarget.push(mp);
	}
	public ArrayList<MealPlan> undoActionMP() {
		if(this.mpStatus.peek().equals(null)) {
			return null;
		}
		String lastAction = this.mpStatus.pop();
		MealPlan lastTarget = this.mpTarget.pop();
		if(lastAction.equals("ADD")) {
			int index = this.mealPlanList.indexOf(lastTarget);
			this.mealPlanList.remove(index);
		}else if(lastAction.equals("DELETE")) {
			this.mealPlanList.add(lastTarget);
		}
		return this.mealPlanList;
	}
}
