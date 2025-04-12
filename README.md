
# Smart Diet Planner

A JavaFX-based desktop application that helps users generate personalized meal plans based on their weight, goal, and diet duration. The system calculates required daily nutritional values and allows users to customize meal items interactively.

---

## Project Structure

```
src/
├── main/
│   ├── java/
│   │   └── smartdietplanner/
│   │       ├── Main.java                        # Application entry point
│   │       ├── controller/                      # JavaFX controllers for each view
│   │       │   ├── DashboardController.java
│   │       │   ├── FoodlistController.java
│   │       │   ├── GoalController.java
│   │       │   ├── MainController.java
│   │       │   ├── PlanController.java
│   │       │   ├── PlanDetailController.java
│   │       │   ├── RegisterController.java
│   │       │   └── UserController.java
│   │       ├── model/                           # Data models
│   │       │   ├── Food.java
│   │       │   ├── MealPlan.java
│   │       │   ├── MealPlanBag.java (ADT interface)
│   │       │   ├── NutritionGoal.java
│   │       │   ├── User.java
│   │       │   └── UserData.java
│   │       ├── service/                         # Business logic and utilities
│   │       │   ├── RecommendationEngine.java
│   │       │   ├── Sorter.java
│   │       │   └── UndoManager.java
│   │       └── util/
│   │           └── FileIO.java
│   └── resources/
│       ├── images/                              # Image resources
│       └── smartdietplanner/view/              # FXML UI layout files
│           ├── Dashboard.fxml
│           ├── Foodlist.fxml
│           ├── Goal.fxml
│           ├── MainView.fxml
│           ├── Plan.fxml
│           ├── PlanDetail.fxml
│           ├── Register.fxml
│           └── User.fxml
```

---

## Environment Requirements

- Java 17+
- JavaFX SDK
- Eclipse IDE or IntelliJ IDEA (recommended)

---

## How to Run

1. **Clone the repository** or import the project into your IDE.
2. **Install JavaFX SDK** and configure it in your IDE:
   - In Eclipse: Add JavaFX library and set VM arguments.
   - In IntelliJ: Add JavaFX SDK in Project Structure.
3. **Run `Main.java`**:
   - Launch the main application window.

---

## Features

- Model-View-Controller-Service (MVCS) design pattern
- Custom ADT interface: `MealPlanBag`
- QuickSort algorithm for food sorting
- Undo functionality for food item operations
- Real-time nutrition feedback and warning
- JavaFX-based interactive UI

---

## Team

Developed by Team ArkNights   
Team members: Yun Xu, Haodong Lyu, Bohao Li
