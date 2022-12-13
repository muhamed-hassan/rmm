package com.poc.level3.dtos;

import java.util.Objects;

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

    public Slot3 getSlot() {
        return slot;
    }

    public void setSlot(Slot3 slot) {
        this.slot = slot;
    }

    public Appointment3 withSelfLink(String uri) {
        getLinks().add(new Link().withUri(uri).withRel(Link.SELF).withType(Link.type.GET.toString()));
        return this;
    }

    public Appointment3 withCancelLink(String uri) {
    	getLinks().add(new Link().withUri(uri).withRel("cancel").withType(Link.type.DELETE.toString()));
        return this;
    }

    public Appointment3 withAddTestLink(String uri) {
    	getLinks().add(new Link().withUri(uri).withRel("addTest").withType(Link.type.PUT.toString()));
        return this;
    }

    public Appointment3 withReScheduleLink(String uri) {
    	getLinks().add(new Link().withUri(uri).withRel("reSchedule").withType(Link.type.POST.toString()));
        return this;
    }

    public Appointment3 withHelpLink(String uri) {        
    	getLinks().add(new Link().withUri(uri).withRel("help").withType(Link.type.GET.toString()));
        return this;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(patient, slot);
		return result;
	}

	@Override
	public boolean equals(Object that) {
		if (this == that)
			return true;
		if (!super.equals(that))
			return false;
		if (getClass() != that.getClass())
			return false;
		var other = (Appointment3) that;
		return Objects.equals(patient, other.patient) 
				&& Objects.equals(slot, other.slot);
	}    
    
}
