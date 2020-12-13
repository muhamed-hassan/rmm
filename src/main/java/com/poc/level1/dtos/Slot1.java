package com.poc.level1.dtos;

import java.util.Objects;

public class Slot1 {

    private int id;

    private int start;

    private int end;

    private String doctor;

    public Slot1() {}

    public Slot1(int id, int start, int end, String doctor) {
        this.id = id;
        this.start = start;
        this.end = end;
        this.doctor = doctor;
    }

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
        Slot1 that = (Slot1) other;
        return Objects.equals(id, that.id);
    }

}
