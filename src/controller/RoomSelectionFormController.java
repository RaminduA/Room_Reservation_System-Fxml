package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Room;
import view.tableModel.RoomTM;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

public class RoomSelectionFormController {
    public Label lblRoomType;
    public JFXButton loadButton;
    public TableColumn colRoomNumber;
    public TableColumn colSelect;
    public TableColumn colAvailability;
    public TableView tblRoom;
    public JFXButton mealPlanButton;
    public JFXButton reserveButton;
    public JFXTextField txtSelectedRoom;
    public AnchorPane roomSelectionContext;

    public void initialize(){
        colRoomNumber.setCellValueFactory(new PropertyValueFactory<>("id"));
        colSelect.setCellValueFactory(new PropertyValueFactory<>("btn1"));
        colAvailability.setCellValueFactory(new PropertyValueFactory<>("btn2"));

    }

    public void setTitleAndLoad(ActionEvent actionEvent) {
        String title="";
        String x=BookingDetailFormController.roomType;
        if(x.equalsIgnoreCase("Single")){
            title="Single";
        }else if(x.equalsIgnoreCase("Double")){
            title="Double";
        }else if(x.equalsIgnoreCase("Triple")){
            title="Triple";
        }else if(x.equalsIgnoreCase("Quad")){
            title="Quad";
        }
        title+=" Rooms";
        lblRoomType.setText(title);
        ArrayList<Room> list=new ArrayList<>();
        for(Room r: UserSelectionFormController.roomList){
            if(x.equalsIgnoreCase(r.getType())){
                list.add(r);
            }
        }
        ObservableList<RoomTM> tmObservableList= FXCollections.observableArrayList();


        for(Room temp: UserSelectionFormController.roomList) {
            /*Button btn1=new Button("Select");
            btn1.setStyle("-fx-background-color: lightcyan");
            btn1.setPrefWidth(colSelect.getWidth());
            Button btn2=new Button("Availability");
            btn2.setStyle("-fx-background-color: yellow");
            btn2.setPrefWidth(colSelect.getWidth());
            tmObservableList.add(new RoomTM(temp.getId(),btn1,btn2));

            btn1.setOnAction((event) -> {

            });
            btn2.setOnAction((event) -> {

            });*/
            //tmObservableList.add(temp);
            System.out.println(temp.getId());
        }
        tblRoom.setItems(tmObservableList);



    }

    public void loadMealPlans(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/MealPlanSelectionForm.fxml"));
        Parent parent=loader.load();
        //MealPlanSelectionFormController controller=loader.getController();
        //controller.setData(tm);
        Scene scene=new Scene(parent);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    public void reserveRoom(ActionEvent actionEvent) throws IOException {
        Stage window = (Stage) roomSelectionContext.getScene().getWindow();
        window.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/ReceptionistDashboardForm.fxml"))));
    }
}
