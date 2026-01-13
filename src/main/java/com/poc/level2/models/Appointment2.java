package com.poc.level2.models;

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
		return Objects.hash(slot, patient);
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
		Appointment2 other = (Appointment2) object;
		return Objects.equals(slot, other.slot) && 
				Objects.equals(patient, other.patient);
	}

}
