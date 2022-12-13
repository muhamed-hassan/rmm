package com.poc.level1.dtos;

import java.util.Objects;

public class Appointment1 {

    private Slot1 slot;

    private String patient;

    private String status;

    public Slot1 getSlot() {
        return slot;
    }

    public void setSlot(Slot1 slot) {
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
		return Objects.hash(patient, slot, status);
	}

	@Override
	public boolean equals(Object that) {
		if (this == that)
			return true;
		if (that == null)
			return false;
		if (getClass() != that.getClass())
			return false;
		var other = (Appointment1) that;
		return Objects.equals(patient, other.patient) 
				&& Objects.equals(slot, other.slot)
				&& Objects.equals(status, other.status);
	}

}
