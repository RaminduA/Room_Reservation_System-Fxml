package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTimePicker;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import model.Customer;
import model.Reservation;

import java.io.IOException;

public class BookingDetailFormController {

    public JFXDatePicker txtCheckInDate;
    public JFXTimePicker txtCheckInTime;
    public JFXDatePicker txtCheckOutDate;
    public JFXTimePicker txtCheckOutTime;
    public JFXTextField txtRoomType;
    public JFXButton bookingSaveButton;
    public AnchorPane roomsTableContext;

    static Reservation lastReserve;
    static String roomType;

    public void saveAndProceed(ActionEvent actionEvent) throws IOException {
        Customer lastCustomer=new Customer();
        for (Customer cust:CustomerDetailFormController.customerList) {
            lastCustomer=cust;
        }
        lastReserve=new Reservation(lastCustomer.getFirstName()+" "+lastCustomer.getLastName(),txtCheckInDate.getValue().toString(),txtCheckInTime.getValue().toString(),txtCheckOutDate.getValue().toString(),txtCheckOutTime.getValue().toString(),"Yet to be Added");
        roomType=txtRoomType.getText();
        print(lastReserve);

        roomsTableContext.getChildren().clear();
        roomsTableContext.getChildren().add(FXMLLoader.load(getClass().getResource("../view/RoomSelectionForm.fxml")));
    }

    public void print(Reservation last){
        System.out.println(last.getCustomerName());
        System.out.println(last.getCheckInDate());
        System.out.println(last.getCheckInTime());
        System.out.println(last.getCheckOutDate());
        System.out.println(last.getCheckOutTime());
        System.out.println(last.getMealPlan());
    }

}
