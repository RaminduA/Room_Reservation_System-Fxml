package controller;

import javafx.event.ActionEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MealPlanSelectionFormController {
    public AnchorPane mealSelectionContext;

    public void selectAndCloseWindow(ActionEvent actionEvent) {
        Stage stage= (Stage)mealSelectionContext.getScene().getWindow();
        stage.close();
    }
}
