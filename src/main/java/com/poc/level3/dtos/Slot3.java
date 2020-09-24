package com.poc.level3.dtos;

import com.poc.level3.hateos.HateosSupport;
import com.poc.level3.hateos.Link;

public class Slot3 extends HateosSupport {

    private int id;

    private int start;

    private int end;

    private String doctor;

    public Slot3() {}

    public Slot3(int id, int start, int end, String doctor) {
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

    public Slot3 withLink(String uri) {
        addLink(new Link(uri, Link.SELF, Link.type.GET.toString()));
        return this;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Slot3 other = (Slot3) obj;
        if (id != other.id)
            return false;
        return true;
    }

}
