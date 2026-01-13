package com.poc.level3.hateos;

import java.util.ArrayList;

public class HateosSupport {

    private ArrayList<EndpointURI> urisOfEndpoints = new ArrayList<EndpointURI>();

    protected void addEndpointURI(EndpointURI endpointURI) {
    	urisOfEndpoints.add(endpointURI);
    }
    
    public ArrayList<EndpointURI> getURIsOfEndpoints() {
		return urisOfEndpoints;
	}

}
