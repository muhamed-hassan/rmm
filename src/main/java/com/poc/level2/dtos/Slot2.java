package com.poc.level2.dtos;

import java.util.Objects;

public class Slot2 {

    private int id;

    private int start;

    private int end;

    private String doctor;

//    public Slot2() {}
//
//    public Slot2(int id, int start, int end, String doctor) {
//        this.id = id;
//        this.start = start;
//        this.end = end;
//        this.doctor = doctor;
//    }

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
    
    public Slot2 withId(int id) {
    	this.id = id;
    	return this;
    }
    
    public Slot2 withStart(int start) {
    	this.start = start;
    	return this;
    }
    
    public Slot2 withEnd(int end) {
    	this.end = end;
    	return this;
    }
    
    public Slot2 withDoctor(String doctor) {
    	this.doctor = doctor;
    	return this;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        Slot2 that = (Slot2) other;
        return Objects.equals(id, that.id);
    }

}
