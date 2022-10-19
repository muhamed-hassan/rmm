package com.poc.level0.dtos;

public class OpenSlot0 {

    private String date;

    private String doctor;

//    public OpenSlot0() {}
//
//    public OpenSlot0(String date, String doctor) {
//        this.date = date;
//        this.doctor = doctor;
//    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }
    
    public OpenSlot0 withDate(String date) {
    	this.date = date;
    	return this;
    }
    
    public OpenSlot0 withDoctor(String doctor) {
    	this.doctor = doctor;
    	return this;
    }

}
