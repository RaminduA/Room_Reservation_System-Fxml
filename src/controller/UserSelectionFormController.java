package controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import model.Room;

import java.io.IOException;
import java.util.ArrayList;

public class UserSelectionFormController {
    public static String user;
    public AnchorPane frontPageContext;
    public AnchorPane userSelectionContext;
    public JFXButton btnAsAdmin;
    public JFXButton btnAsReceptionist;
    public static ArrayList<Room> roomList=new ArrayList<>();

    static{
        for(int i=1;i<=25;i++){
            String id="R";
            String type="";
            if(i<10){
                id=id+"0"+i;
            }else{
                id=id+i;
            }
            if(i%4==0){
                type="Quad";
            }else if(i%3==0){
                type="Triple";
            }else if(i%2==0){
                type="Double";
            }else{
                type="Single";
            }
            Room room=new Room(id,type);
        }
    }

    public void openLoginForm(ActionEvent actionEvent) throws IOException {
        if(actionEvent.getSource()==btnAsAdmin){
            //System.out.println("Login as Admin");
            user="Admin";
        }else if(actionEvent.getSource()==btnAsReceptionist){
            //System.out.println("Login as Receptionist");
            user="Receptionist";
        }
        userSelectionContext.getChildren().add(FXMLLoader.load(getClass().getResource("../view/LoginForm.fxml")));
        //System.out.println("Login Form Opened");
    }
}
