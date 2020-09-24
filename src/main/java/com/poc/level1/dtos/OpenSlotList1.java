package com.poc.level1.dtos;

import java.util.List;

public class OpenSlotList1 {

    private List<Slot1> slots;

    public OpenSlotList1(List<Slot1> slots) {
        this.slots = slots;
    }

    public List<Slot1> getSlots() {
        return slots;
    }

    public void setSlots(List<Slot1> slots) {
        this.slots = slots;
    }

}
