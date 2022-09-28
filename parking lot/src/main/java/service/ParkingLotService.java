package main.java.service;

import main.java.model.ParkingLot;
import main.java.model.Slot;
import main.java.model.Vehicle;
import main.java.service.strategy.ParkingSlotStrategy;

public class ParkingLotService {
    private ParkingLot parkingLot;

    public ParkingLotService(int capacity) {
        parkingLot = new ParkingLot(capacity);
    }

    public void parkVehicle(ParkingSlotStrategy parkingSlotStrategy, Vehicle vehicle) throws Exception
    {
        Integer slotNo = parkingSlotStrategy.nextSlot();
        Slot slot = parkingLot.getSlot(slotNo);
        parkingLot.park(slot, vehicle);
    }

    public void freeSlot(Integer slotNo, ParkingSlotStrategy parkingSlotStrategy){
        Slot slot = parkingLot.getSlot(slotNo);
        parkingLot.unpark(slot);
        parkingSlotStrategy.addSlot(slotNo);
    }
}
