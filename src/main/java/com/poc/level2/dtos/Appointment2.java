package com.poc.level2.dtos;

import java.util.Objects;

import com.poc.level1.dtos.Appointment1;
import com.poc.level1.dtos.Slot1;

public class Appointment2 {

    private Slot2 slot;

    private String patient;

//    public Appointment2() {}
//
//    public Appointment2(Slot2 slot, String patient) {
//        this.slot = slot;
//        this.patient = patient;
//    }

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
    
    public Appointment2 withSlot(Slot2 slot) {
    	this.slot = slot;
    	return this;
    }
    
    public Appointment2 withPatient(String patient) {
    	this.patient = patient;
    	return this;
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
		Appointment2 other = (Appointment2) that;
		return Objects.equals(patient, other.patient) && Objects.equals(slot, other.slot);
	}
    

}
