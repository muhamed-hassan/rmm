package com.poc.level0.models;

import java.util.Objects;

public class Slot0 {

    private int start;

    private int end;

    private String doctor;

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
		return Objects.hash(start, end, doctor);
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
		Slot0 other = (Slot0) object;
		return start == other.start && 
				end == other.end && 
				Objects.equals(doctor, other.doctor);
	}

}
