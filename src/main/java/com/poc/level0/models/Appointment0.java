package com.poc.level0.models;

import java.util.Objects;

public class Appointment0 {

    private Slot0 slot;

    private String patient;

    private String status;

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

	@Override
	public int hashCode() {
		return Objects.hash(slot, patient, status);
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}
		if (object == null) {
			return false;
		}
		if (getClass() != object.getClass()) {
			return false;
		}
		Appointment0 other = (Appointment0) object;
		return Objects.equals(slot, other.slot) && 
				Objects.equals(patient, other.patient) && 
				Objects.equals(status, other.status);
	}

}
