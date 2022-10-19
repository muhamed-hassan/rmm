package com.poc.level0.dtos;

import java.util.Objects;

public class Appointment0 {

    private Slot0 slot;

    private String patient;

    private String status;

//    public Appointment0() {}
//
//    public Appointment0(final Slot0 slot, final String patient, final String status) {
//        this.slot = slot;
//        this.patient = patient;
//        this.status = status;
//    }

    public Slot0 getSlot() {
        return slot;
    }

    public void setSlot(/*final*/ Slot0 slot) {
        this.slot = slot;
    }

    public String getPatient() {
        return patient;
    }

    public void setPatient(/*final*/ String patient) {
        this.patient = patient;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(/*final*/ String status) {
        this.status = status;
    }
    
    public Appointment0 withSlot(Slot0 slot) {
    	this.slot = slot;
    	return this;
    }
    
    public Appointment0 withPatient(String patient) {
    	this.patient = patient;
    	return this;
    }
    
    public Appointment0 withStatus(String status) {
    	this.status = status;
    	return this;
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
		Appointment0 other = (Appointment0) that;
		return Objects.equals(patient, other.patient) && Objects.equals(slot, other.slot)
				&& Objects.equals(status, other.status);
	}
    
    

}
