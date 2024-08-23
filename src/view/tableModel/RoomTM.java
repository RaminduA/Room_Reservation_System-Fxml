package view.tableModel;

import javax.swing.*;
import javafx.scene.control.Button;

public class RoomTM {
    private String id;
    private Button btn1;
    private Button btn2;

    public RoomTM() {

    }

    public RoomTM(String id, Button btn1, Button btn2) {
        this.id = id;
        this.btn1 = btn1;
        this.btn2 = btn2;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Button getBtn1() {
        return btn1;
    }

    public void setBtn1(Button btn1) {
        this.btn1 = btn1;
    }

    public Button getBtn2() {
        return btn2;
    }

    public void setBtn2(Button btn2) {
        this.btn2 = btn2;
    }


}
