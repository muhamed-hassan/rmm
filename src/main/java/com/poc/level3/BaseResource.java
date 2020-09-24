package com.poc.level3;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

public class BaseResource {

    protected String constructUri(String baseApiUri, String appendToCurrentUri) {
        String contextPath = ServletUriComponentsBuilder.fromCurrentContextPath().toUriString();
        return new StringBuilder(contextPath)
                        .append(baseApiUri)
                        .append(appendToCurrentUri)
                        .toString();
    }

}
