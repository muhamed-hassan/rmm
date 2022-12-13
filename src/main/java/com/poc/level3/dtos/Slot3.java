package com.poc.level3.dtos;

import java.util.Objects;

import com.poc.level3.hateos.HateosSupport;
import com.poc.level3.hateos.Link;

public class Slot3 extends HateosSupport {

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
    
    public Slot3 withLink(String uri) {
    	getLinks().add(new Link().withUri(uri).withRel(Link.SELF).withType(Link.type.GET.toString()));
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
        var that = (Slot3) other;
        return Objects.equals(id, that.id);
    }

}
