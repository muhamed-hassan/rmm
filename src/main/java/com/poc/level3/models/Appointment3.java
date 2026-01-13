package com.poc.level3.models;

import com.poc.level3.hateos.HateosSupport;
import com.poc.level3.hateos.EndpointURI;
import com.poc.level3.hateos.HttpMethod;

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

    public void setCancelEndpointURI(String uri) {
    	EndpointURI endpointURI = new EndpointURI();
    	endpointURI.setUri(uri);
    	endpointURI.setHttpMethod(HttpMethod.DELETE);
    	addEndpointURI(endpointURI);
    }

    public void setAddTestEndpointURI(String uri) {
    	EndpointURI endpointURI = new EndpointURI();
    	endpointURI.setUri(uri);
    	endpointURI.setHttpMethod(HttpMethod.PUT);
    	addEndpointURI(endpointURI);
    }

    public void setRescheduleEndpointURI(String uri) {
    	EndpointURI endpointURI = new EndpointURI();
    	endpointURI.setUri(uri);
    	endpointURI.setHttpMethod(HttpMethod.POST);
    	addEndpointURI(endpointURI);
    }

    public void setHelpEndpointURI(String uri) {        
    	EndpointURI endpointURI = new EndpointURI();
    	endpointURI.setUri(uri);
    	endpointURI.setHttpMethod(HttpMethod.GET);
    	addEndpointURI(endpointURI);
    }

	@Override
	public int hashCode() {
		int prime = 31;
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
