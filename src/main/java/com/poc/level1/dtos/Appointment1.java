package com.poc.level1.dtos;

import java.util.Objects;

import com.poc.level0.dtos.Appointment0;
import com.poc.level0.dtos.Slot0;

public class Appointment1 {

    private Slot1 slot;

    private String patient;

    private String status;

//    public Appointment1() {}
//
//    public Appointment1(Slot1 slot, String patient, String status) {
//        this.slot = slot;
//        this.patient = patient;
//        this.status = status;
//    }

    public Slot1 getSlot() {
        return slot;
    }

    public void setSlot(/*final */Slot1 slot) {
        this.slot = slot;
    }

    public String getPatient() {
        return patient;
    }

    public void setPatient(/*final */String patient) {
        this.patient = patient;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(/*final */String status) {
        this.status = status;
    }
    
    public Appointment1 withSlot(Slot1 slot) {
    	this.slot = slot;
    	return this;
    }
    
    public Appointment1 withPatient(String patient) {
    	this.patient = patient;
    	return this;
    }
    
    public Appointment1 withStatus(String status) {
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
		Appointment1 other = (Appointment1) that;
		return Objects.equals(patient, other.patient) && Objects.equals(slot, other.slot)
				&& Objects.equals(status, other.status);
	}

}
