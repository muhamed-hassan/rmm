package com.poc.level3.models;

import com.poc.level3.hateos.HateosSupport;
import com.poc.level3.hateos.EndpointURI;
import com.poc.level3.hateos.HttpMethod;

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
    
    public void setEndpointURI(String uri) {
    	EndpointURI endpointURI = new EndpointURI();
    	endpointURI.setUri(uri);
    	endpointURI.setHttpMethod(HttpMethod.GET);
    	addEndpointURI(endpointURI);
    }

	@Override
	public int hashCode() {
		int prime = 31;
		int result = super.hashCode();
		result = prime * result + id;
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
		Slot3 other = (Slot3) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
