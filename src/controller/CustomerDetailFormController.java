package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.AnchorPane;
import model.Customer;

import java.io.IOException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class CustomerDetailFormController {
    public AnchorPane bookingFormContext;
    public JFXTextField txtGuestCount;
    public JFXTextField txtFirstName;
    public JFXTextField txtLastName;
    public JFXTextField txtEmail;
    public JFXTextField txtContact;
    public JFXTextField txtId;
    public JFXTextArea txtAddress;
    public JFXButton customerSaveButton;

    public static ArrayList<Customer> customerList=new ArrayList<>();


    {
        //txtAddress.setText("ABCD");
    }
    public void initialize(){
        /*ArrayList<Integer> gc=new ArrayList<>();
        for(int i=0;i<15;i++){
            gc.add(i+1);
        }
        ObservableList<Integer> guestCount= FXCollections.observableList(gc);
        cmbGuestCount.getItems().addAll(guestCount);*/

    }

    public void saveAndProceed(ActionEvent actionEvent) throws IOException {
        Customer customer=new Customer(txtFirstName.getText(),txtLastName.getText(),txtEmail.getText(),txtContact.getText(),txtId.getText(),txtAddress.getText(),Integer.valueOf(txtGuestCount.getText()));
        if(!isExists(customer)){
            if(customerList.add(customer)){
                //loadAllStudents();
                clearFields();
                //print(customer);
                bookingFormContext.getChildren().clear();
                bookingFormContext.getChildren().add(FXMLLoader.load(getClass().getResource("../view/BookingDetailForm.fxml")));
            }else{
                 new Alert(Alert.AlertType.WARNING, "Try Again..", ButtonType.CLOSE).show();
            }
        }else{
                new Alert(Alert.AlertType.WARNING, "Already Exists..", ButtonType.CLOSE).show();
        }
    }

    private void print(Customer customer) {
        System.out.println(customer.getFirstName());
        System.out.println(customer.getLastName());
        System.out.println(customer.getEmail());
        System.out.println(customer.getContact());
        System.out.println(customer.getId());
        System.out.println(customer.getAddress());
        System.out.println(customer.getGuestCount());
    }

    private boolean isExists(Customer customer) {
        for (Customer temp: customerList){
            if (temp.getId().equalsIgnoreCase(customer.getId())) {
                return true;
            }
        }
        return false;
    }
    private void clearFields() {
        txtFirstName.clear();
        txtLastName.clear();
        txtEmail.clear();
        txtContact.clear();
        txtId.clear();
        txtAddress.clear();
        txtGuestCount.clear();
    }
}
