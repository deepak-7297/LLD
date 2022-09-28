package main.java.model;

public class Slot {
    private int id;
    private Vehicle vehicle;

    public Slot(int id){

    }

    public boolean slotEmpty(){
        return vehicle==null;
    }

    public void unAssignCar(){
        vehicle=null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}
