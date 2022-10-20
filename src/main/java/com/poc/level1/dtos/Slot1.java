package com.poc.level1.dtos;

import java.util.Objects;

public class Slot1 {

    private int id;

    private int start;

    private int end;

    private String doctor;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }
    
    public Slot1 withId(int id) {
    	this.id = id;
    	return this;
    }
    
    public Slot1 withStart(int start) {
    	this.start = start;
    	return this;
    }
    
    public Slot1 withEnd(int end) {
    	this.end = end;
    	return this;
    }
    
    public Slot1 withDoctor(String doctor) {
    	this.doctor = doctor;
    	return this;
    }

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object that) {
		if (this == that)
			return true;
		if (that == null)
			return false;
		if (getClass() != that.getClass())
			return false;
		var other = (Slot1) that;
		return id == other.id;
	}	

}
