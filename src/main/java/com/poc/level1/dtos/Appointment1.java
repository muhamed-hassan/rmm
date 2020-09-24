package com.poc.level1.dtos;

public class Appointment1 {

    private Slot1 slot;

    private String patient;

    private String status;

    public Appointment1() {}

    public Appointment1(Slot1 slot, String patient, String status) {
        this.slot = slot;
        this.patient = patient;
        this.status = status;
    }

    public Slot1 getSlot() {
        return slot;
    }

    public void setSlot(final Slot1 slot) {
        this.slot = slot;
    }

    public String getPatient() {
        return patient;
    }

    public void setPatient(final String patient) {
        this.patient = patient;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(final String status) {
        this.status = status;
    }

}
