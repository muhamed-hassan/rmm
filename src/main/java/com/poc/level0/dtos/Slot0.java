package com.poc.level0.dtos;

import java.util.Objects;

public class Slot0 {

    private int start;

    private int end;

    private String doctor;

//    public Slot0() {}
//
//    public Slot0(int start, int end, String doctor) {
//        this.start = start;
//        this.end = end;
//        this.doctor = doctor;
//    }

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
    
    public Slot0 withStart(int start) {
    	this.start = start;
    	return this;
    }
    
    public Slot0 withEnd(int end) {
    	this.end = end;
    	return this;
    }
    
    public Slot0 withDoctor(String doctor) {
    	this.doctor = doctor;
    	return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(doctor, end, start);
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        Slot0 that = (Slot0) other;
        return Objects.equals(doctor, that.doctor)
            && Objects.equals(end, that.end)
            && Objects.equals(start, that.start);
    }

}
