package smartdietplanner.service;

import java.util.ArrayList;

import smartdietplanner.model.Food;

public class Sorter {
    private ArrayList<Food> foodList;
    /**
     * A sorter for sorting the food list
     * @param name True if the list is sorted by name false, if not
     * @param calories True if the list is sorted by calories false, if not
     * @param protein True if the list is sorted by protein false, if not
     * @param carbs True if the list is sorted by carbs false, if not
     * @param fat True if the list is sorted by fat false, if not
     * @param reverse  True if the list is sorted in descending orders
     * @param foodList The list to be sorted
     */
    public Sorter(boolean name, boolean calories, boolean protein, boolean carbs, boolean fat, boolean reverse, ArrayList<Food> foodList) {
        this.foodList = foodList;
        if(calories) {
        	sortBasedOnCalories();
        }else if(protein) {
        	sortBasedOnProtein();
        }else if(carbs) {
        	sortBasedOnCarbs();
        }else if(fat) {
        	sortBasedOnFat();
        }else if(name) {
        	sortBasedOnName();
        }
        if(reverse) {
        	reverseSortedList();
        }
    }
    public ArrayList<Food> getSortedFoodList(){
    	return this.foodList;
    }
    /**
     * Sort the food list based on name
     */
	private void sortBasedOnName() {
		// TODO Auto-generated method stub
		this.foodList.sort((o1, o2) -> o1.getName().compareTo(o2.getName()));
	}
	private void reverseSortedList() {
		ArrayList<Food> temp = new ArrayList<>();
		for(int i = this.foodList.size()-1; i > -1; i--) {
			temp.add(this.foodList.get(i));
		}
		this.foodList = temp;
	}
    /**
     * Sort the food list based on fat
     */
	private void sortBasedOnFat() {
		// TODO Auto-generated method stub
		quickSort(this.foodList, 0, this.foodList.size()-1, "fat");
	}
	/**
     * Sort the carb list based on carb
     */
	private void sortBasedOnCarbs() {
		// TODO Auto-generated method stub
		quickSort(this.foodList, 0, this.foodList.size()-1, "carb");
	}
	/**
     * Sort the protein list based on protein
     */
	private void sortBasedOnProtein() {
		// TODO Auto-generated method stub
		quickSort(this.foodList, 0, this.foodList.size()-1, "protein");
	}
	/**
     * Sort the calories list based on calories
     */
	private void sortBasedOnCalories() {
		// TODO Auto-generated method stub
		quickSort(this.foodList, 0, this.foodList.size()-1, "calories");
	}
	/**
	 * Use quick sort to sort the food list based on specific type
	 * @param arr the food list to be sorted
	 * @param begin the beginning index
	 * @param end the ending index
	 * @param type the type the sorting based on
	 */
	private void quickSort(ArrayList<Food>arr, int begin, int end, String type) {
	    if (begin < end) {
	        int partitionIndex = partition(arr, begin, end, type);

	        quickSort(arr, begin, partitionIndex-1, type);
	        quickSort(arr, partitionIndex+1, end, type);
	    }
	}
	private int partition(ArrayList<Food> arr, int begin, int end, String type) {
	    Food pivot = arr.get(end);
	    int i = (begin-1);

	    for (int j = begin; j < end; j++) {
	    	double data = 0.0;
	    	double pivotData = 0.0;
	    	if(type.equals("calories")) {
	    		data = arr.get(j).getCalories();
    			pivotData = pivot.getCalories();
	    	}else if(type.equals("fat")) {
	    		data = arr.get(j).getFat();
    			pivotData = pivot.getFat();
	    	}else if(type.equals("protein")) {
	    		data = arr.get(j).getProtein();
    			pivotData = pivot.getProtein();
	    	}else if(type.equals("carb")) {
	    		data = arr.get(j).getCarbs();
    			pivotData = pivot.getCarbs();
	    	}
	        if (data <= pivotData) {
	            i++;

	            Food swapTemp = arr.get(i);
	            arr.set(i, arr.get(j));
	            arr.set(j, swapTemp);
	        }
	    }
	    Food swapTemp = arr.get(i+1);
	    arr.set(i+1, arr.get(end));
        arr.set(end, swapTemp);
	    return i+1;
	}
}
