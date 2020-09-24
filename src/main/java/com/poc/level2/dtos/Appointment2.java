package com.poc.level2.dtos;

public class Appointment2 {

    private Slot2 slot;

    private String patient;

    public Appointment2() {}

    public Appointment2(Slot2 slot, String patient) {
        this.slot = slot;
        this.patient = patient;
    }

    public Slot2 getSlot() {
        return slot;
    }

    public void setSlot(Slot2 slot) {
        this.slot = slot;
    }

    public String getPatient() {
        return patient;
    }

    public void setPatient(String patient) {
        this.patient = patient;
    }

}
