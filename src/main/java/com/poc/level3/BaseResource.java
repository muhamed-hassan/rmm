package com.poc.level3;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

public class BaseResource {

    protected String constructUri(String baseApiUri, String appendToCurrentUri) {    	
    	String contextPath = ServletUriComponentsBuilder.fromCurrentContextPath().toString();
    	String uri = contextPath + baseApiUri + appendToCurrentUri;
        return uri;
    }

}
