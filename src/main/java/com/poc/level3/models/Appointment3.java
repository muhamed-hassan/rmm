package com.poc.level3.models;

import com.poc.level3.hateos.HateosSupport;

import java.util.Objects;

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
		return Objects.hash(slot, patient);
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
		Appointment3 other = (Appointment3) object;
		return Objects.equals(slot, other.slot) &&
				Objects.equals(patient, other.patient);
	}

}
