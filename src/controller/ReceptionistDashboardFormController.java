package controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class ReceptionistDashboardFormController {
    public AnchorPane dashboardContext;
    public AnchorPane bookingFormContext;
    public JFXButton logoutButton;

    public void backToUserSelect(ActionEvent actionEvent) throws IOException {
        Stage window=(Stage)dashboardContext.getScene().getWindow();
        window.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/UserSelectionForm.fxml"))));
    }
    public void popupBokingForm(ActionEvent actionEvent) throws IOException {
        bookingFormContext.getChildren().add(FXMLLoader.load(getClass().getResource("../view/CustomerDetailForm.fxml")));
    }

    public void popupGuestDetailForm(ActionEvent actionEvent) throws IOException {
        bookingFormContext.getChildren().add(FXMLLoader.load(getClass().getResource("../view/ViewGuestsForm.fxml")));
    }

    public void loadHomePage(MouseEvent mouseEvent) throws IOException {
        Stage window=(Stage)dashboardContext.getScene().getWindow();
        window.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/ReceptionistDashboardForm.fxml"))));
    }
}
