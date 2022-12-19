package com.poc.level3.dtos;

import static com.poc.level3.hateos.Link.SELF;
import static com.poc.level3.hateos.Link.Type.GET;
import static com.poc.level3.hateos.Link.Type.POST;
import static com.poc.level3.hateos.Link.Type.DELETE;
import static com.poc.level3.hateos.Link.Type.PUT;

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
    	Link link = new Link();
    	link.setUri(uri);
    	link.setRel(SELF);
    	link.setType(GET);
    	addLink(link);
        return this;
    }

    public Appointment3 withCancelLink(String uri) {
    	Link link = new Link();
    	link.setUri(uri);
    	link.setRel("cancel");
    	link.setType(DELETE);
    	addLink(link);
        return this;
    }

    public Appointment3 withAddTestLink(String uri) {
    	Link link = new Link();
    	link.setUri(uri);
    	link.setRel("addTest");
    	link.setType(PUT);
    	addLink(link);
        return this;
    }

    public Appointment3 withReScheduleLink(String uri) {
    	Link link = new Link();
    	link.setUri(uri);
    	link.setRel("reSchedule");
    	link.setType(POST);
    	addLink(link);
        return this;
    }

    public Appointment3 withHelpLink(String uri) {        
    	Link link = new Link();
    	link.setUri(uri);
    	link.setRel("help");
    	link.setType(GET);
    	addLink(link);
        return this;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((patient == null) ? 0 : patient.hashCode());
		result = prime * result + ((slot == null) ? 0 : slot.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Appointment3 other = (Appointment3) obj;
		if (patient == null) {
			if (other.patient != null)
				return false;
		} else if (!patient.equals(other.patient))
			return false;
		if (slot == null) {
			if (other.slot != null)
				return false;
		} else if (!slot.equals(other.slot))
			return false;
		return true;
	}
    
}
