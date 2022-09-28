package main.java.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class ParkingLot {
    private Map<Integer, Slot> slots;
    private int capacity;
    private String Address;

    public ParkingLot(int capacity) {
        this.capacity = capacity;
        this.slots = new HashMap<>(capacity);
        for(int i=0;i<capacity;i++){
            this.slots.put(i+1, new Slot(i+1));
        }
    }

    public void unpark(Slot slot){
        slot.unAssignCar();
    }

    public void park(Slot slot, Vehicle vehicle) throws Exception{
        if(slot.slotEmpty()){
            slot.setVehicle(vehicle);
        }else
            throw new Exception("Slot FULL");
    }

    public Map<Integer, Slot> getSlots() {
        return slots;
    }

    public Slot getSlot(Integer slotNo){
        return slots.get(slotNo);
    }

    public void setSlots(Map<Integer, Slot> slots) {
        this.slots = slots;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
