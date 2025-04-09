package smartdietplanner.model;

public class NutritionGoal {
    private double targetCalories;
    private double targetProtein;
    private double targetCarbs;
    private double targetFat;

    // Constructor with custom nutrition goals
    public NutritionGoal(double targetCalories, double targetProtein, double targetCarbs, double targetFat) {
        this.targetCalories = targetCalories;
        this.targetProtein = targetProtein;
        this.targetCarbs = targetCarbs;
        this.targetFat = targetFat;
    }

    // Constructor that calculates goals based on weight loss and diet days
    public NutritionGoal(double currentWeight, double goalWeight, int dietDays) {
        double weightDiff = currentWeight - goalWeight;
        double totalCalorieDeficit = weightDiff * 3500;  // 1 lb ≈ 3500 calories
        double dailyCalorieDeficit = totalCalorieDeficit / dietDays;

        double maintenanceCalories = currentWeight * 15; // estimated maintenance level
        this.targetCalories = maintenanceCalories - dailyCalorieDeficit;

        // Macronutrient distribution: 30% protein, 40% carbs, 30% fat
        this.targetProtein = (targetCalories * 0.30) / 4;
        this.targetCarbs   = (targetCalories * 0.40) / 4;
        this.targetFat     = (targetCalories * 0.30) / 9;
    }

    public double getTargetCalories() {
        return targetCalories;
    }

    public void setTargetCalories(double targetCalories) {
        this.targetCalories = targetCalories;
    }

    public double getTargetProtein() {
        return targetProtein;
    }

    public void setTargetProtein(double targetProtein) {
        this.targetProtein = targetProtein;
    }

    public double getTargetCarbs() {
        return targetCarbs;
    }

    public void setTargetCarbs(double targetCarbs) {
        this.targetCarbs = targetCarbs;
    }

    public double getTargetFat() {
        return targetFat;
    }

    public void setTargetFat(double targetFat) {
        this.targetFat = targetFat;
    }

    @Override
    public String toString() {
        return "NutritionGoal [Calories=" + targetCalories +
                ", Protein=" + targetProtein + "g, Carbs=" + targetCarbs +
                "g, Fat=" + targetFat + "g]";
    }
}
