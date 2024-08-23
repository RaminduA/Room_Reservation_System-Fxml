package model;

import java.util.ArrayList;

public class Room {
    private String id;
    private String type;
    private String status="Available";

    public static ArrayList<Reservation> reserveList=new ArrayList<>();

    public Room() {

    }
    public Room(String id, String type) {
        this.id = id;
        this.type = type;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


}
