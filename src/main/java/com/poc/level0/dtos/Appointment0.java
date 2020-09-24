package com.poc.level0.dtos;

public class Appointment0 {

    private Slot0 slot;

    private String patient;

    private String status;

    public Appointment0() {}

    public Appointment0(final Slot0 slot, final String patient, final String status) {
        this.slot = slot;
        this.patient = patient;
        this.status = status;
    }

    public Slot0 getSlot() {
        return slot;
    }

    public void setSlot(final Slot0 slot) {
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
