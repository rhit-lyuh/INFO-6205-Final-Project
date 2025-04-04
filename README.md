# SmartDietPlanner

SmartDietPlanner is a JavaFX-based desktop application designed to help users plan their meals based on nutritional goals. This project is developed as a final group project for the INFO-6205 course.

## Features
- Input daily food and nutrition intake
- Set personal nutritional goals (e.g., protein, carbs, fat)
- Get recommended meal combinations to meet goals
- Support undo functionality for food selection
- Clean and modular design following MVC architecture

##  Project Structure

```
SmartDietPlanner/
├── src/
│   └── main/
│       ├── java/
│       │   ├── smartdietplanner/
│       │   │   └── Main.java
│       │   ├── smartdietplanner.controller/
│       │   │   └── MainController.java
│       │   ├── smartdietplanner.model/
│       │   │   ├── Food.java
│       │   │   ├── MealPlan.java
│       │   │   └── NutritionGoal.java
│       │   ├── smartdietplanner.service/
│       │   │   ├── RecommendationEngine.java
│       │   │   ├── Sorter.java
│       │   │   └── UndoManager.java
│       │   └── smartdietplanner.util/
│       └── resources/
│           ├── images/
│           └── smartdietplanner.view/
├── README.md
```

## Team
Developed by Team ArkNights 
Team members: Yun Xu, Haodong Lyu, Bohao Li