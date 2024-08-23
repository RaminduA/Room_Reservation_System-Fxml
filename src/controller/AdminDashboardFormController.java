package controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class AdminDashboardFormController {
    public AnchorPane dashboardContext;
    public JFXButton logoutButton;

    public void backToUserSelect(ActionEvent actionEvent) throws IOException {
        Stage window=(Stage)dashboardContext.getScene().getWindow();
        window.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/UserSelectionForm.fxml"))));
    }

    public void openIncomeReports(ActionEvent actionEvent) throws IOException {
        dashboardContext.getChildren().add(FXMLLoader.load(getClass().getResource("../view/IncomeReportsForm.fxml")));
    }

    public void openMealSection(ActionEvent actionEvent) throws IOException {
        dashboardContext.getChildren().add(FXMLLoader.load(getClass().getResource("../view/MealSectionForm.fxml")));
    }

    public void loadHomePage(MouseEvent mouseEvent) throws IOException {
        Stage window=(Stage)dashboardContext.getScene().getWindow();
        window.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/AdminDashboardForm.fxml"))));
    }

    public void openRoomManagingSection(ActionEvent actionEvent) throws IOException {
        dashboardContext.getChildren().add(FXMLLoader.load(getClass().getResource("../view/RoomManagingForm.fxml")));
    }
}
