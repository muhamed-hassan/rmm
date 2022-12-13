package com.poc.level2.dtos;

import java.util.Objects;

public class Appointment2 {

    private Slot2 slot;

    private String patient;

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

	@Override
	public int hashCode() {
		return Objects.hash(patient, slot);
	}

	@Override
	public boolean equals(Object that) {
		if (this == that)
			return true;
		if (that == null)
			return false;
		if (getClass() != that.getClass())
			return false;
		var other = (Appointment2) that;
		return Objects.equals(patient, other.patient) 
				&& Objects.equals(slot, other.slot);
	}    

}
