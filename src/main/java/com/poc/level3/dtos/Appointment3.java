package com.poc.level3.dtos;

import com.poc.level3.hateos.HateosSupport;
import com.poc.level3.hateos.Link;

public class Appointment3 extends HateosSupport {

    private Slot3 slot;

    private String patient;

    public String getPatient() {
        return patient;
    }

    public void setPatient(String patient) {
        this.patient = patient;
    }

    public Appointment3(Slot3 slot, String patient) {
        setSlot(slot);
        setPatient(patient);
    }

    public Slot3 getSlot() {
        return slot;
    }

    public void setSlot(Slot3 slot) {
        this.slot = slot;
    }

    public Appointment3 withSelfLink(String uri) {
        addLink(new Link(uri, Link.SELF, Link.type.GET.toString()));
        return this;
    }

    public Appointment3 withCancelLink(String uri) {
        addLink(new Link(uri, "cancel", Link.type.DELETE.toString()));
        return this;
    }

    public Appointment3 withAddTestLink(String uri) {
        addLink(new Link(uri, "addTest", Link.type.PUT.toString()));
        return this;
    }

    public Appointment3 withReScheduleLink(String uri) {
        addLink(new Link(uri, "reSchedule", Link.type.POST.toString()));
        return this;
    }

    public Appointment3 withHelpLink(String uri) {
        addLink(new Link(uri, "help", Link.type.GET.toString()));
        return this;
    }

}
