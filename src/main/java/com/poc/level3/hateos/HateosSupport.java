package com.poc.level3.hateos;

import java.util.ArrayList;
import java.util.List;

public class HateosSupport {

    private List<EndpointURI> urisOfEndpoints = new ArrayList<EndpointURI>();

    protected void addEndpointURI(EndpointURI endpointURI) {
    	urisOfEndpoints.add(endpointURI);
    }
    
    public List<EndpointURI> getURIsOfEndpoints() {
		return urisOfEndpoints;
	}

	@Override
	public int hashCode() {
		int prime = 31;
		int result = 1;
		result = prime * result + ((urisOfEndpoints == null) ? 0 : urisOfEndpoints.hashCode());
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
		HateosSupport other = (HateosSupport) obj;
		if (urisOfEndpoints == null) {
			if (other.urisOfEndpoints != null)
				return false;
		} else if (!urisOfEndpoints.equals(other.urisOfEndpoints))
			return false;
		return true;
	}

}
