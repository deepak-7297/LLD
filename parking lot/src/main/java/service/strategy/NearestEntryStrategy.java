package main.java.service.strategy;

import main.java.model.Slot;

import java.util.TreeSet;

public class NearestEntryStrategy implements ParkingSlotStrategy {
    private TreeSet<Integer> slots;

    public NearestEntryStrategy() {
        slots = new TreeSet<>();
    }

    @Override
    public Integer nextSlot() {
        Integer slotNo =slots.first();
        removeSlot(slotNo);
        return slotNo;
    }

    @Override
    public void addSlot(Integer slotNo) {
        slots.add(slotNo);
    }

    @Override
    public void removeSlot(Integer slotNo) {
        slots.remove(slotNo);
    }

}
