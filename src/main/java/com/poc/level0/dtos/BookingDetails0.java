package com.poc.level0.dtos;

public class BookingDetails0 {

    private Slot0 slot;

    private String patient;

    public BookingDetails0() {}

    public BookingDetails0(Slot0 slot, String patient) {
        this.slot = slot;
        this.patient = patient;
    }

    public Slot0 getSlot() {
        return slot;
    }

    public void setSlot(Slot0 slot) {
        this.slot = slot;
    }

    public String getPatient() {
        return patient;
    }

    public void setPatient(String patient) {
        this.patient = patient;
    }

}
