package main.java.service.strategy;

import main.java.model.Slot;

public interface  ParkingSlotStrategy {
    public Integer nextSlot();

    public void addSlot(Integer slotNo);

    public void removeSlot(Integer slotNo);
}
