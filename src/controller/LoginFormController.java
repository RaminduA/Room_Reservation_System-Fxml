package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginFormController {
    public AnchorPane loginFormContext;
    public JFXTextField usernameField;
    public JFXPasswordField passwordField;
    public JFXButton loginButton;
    public ImageView homeButton;
    public Label warningLine1;
    public Label warningLine2;


    public void onActionLogin(ActionEvent actionEvent) throws IOException {
        if(UserSelectionFormController.user=="Admin"){
            //System.out.println("AAA");
            if(usernameField.getText().equals("admin") && passwordField.getText().equals("admin")){
                System.out.println("Admin In");
                Stage window=(Stage)loginFormContext.getScene().getWindow();
                window.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/AdminDashboardForm.fxml"))));
            }else{
                warningLine1.setText("The username or password you entered");
                warningLine2.setText("is incorrect");
                warningLine1.setStyle("-fx-background-color: #292929");
                warningLine2.setStyle("-fx-background-color: #292929");
            }
        }else if(UserSelectionFormController.user=="Receptionist"){
            //System.out.println("RRR");
            if(usernameField.getText().equals("recep") && passwordField.getText().equals("recep")){
                System.out.println("Receptionist In");
                Stage window=(Stage)loginFormContext.getScene().getWindow();
                window.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/ReceptionistDashboardForm.fxml"))));
            }else{
                warningLine1.setText("The username or password you entered");
                warningLine2.setText("is incorrect");
                warningLine1.setStyle("-fx-background-color: #292929");
                warningLine2.setStyle("-fx-background-color: #292929");
            }
        }
        usernameField.clear();
        passwordField.clear();
    }

    public void moveToPassword(ActionEvent actionEvent) {
    }

    public void backToHome(MouseEvent mouseEvent) throws IOException {
        Stage window=(Stage)loginFormContext.getScene().getWindow();
        window.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/UserSelectionForm.fxml"))));
    }
}
