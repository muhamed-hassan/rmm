package com.poc.level3.hateos;

import java.util.Objects;

public class Link {

    public static final String SELF = "self";

    public enum type {
        GET,
        POST,
        DELETE,
        PUT
    };

    private String uri;

    private String rel;

    private String type;

//    public Link(String uri, String rel, String type) {
//        this.uri = uri;
//        this.rel = rel;
//        this.type = type;
//    }

    public String getUri() {
        return uri;
    }

    public String getRel() {
        return rel;
    }

    public String getType() {
        return type;
    }
    
    public Link withUri(String uri) {
    	this.uri = uri;
        return this;
    }

    public Link withRel(String rel) {
    	this.rel = rel;
    	return this;
    }

    public Link withType(String type) {
    	this.type = type;
    	return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(rel, type, uri);
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        Link that = (Link) other;
        return Objects.equals(rel, that.rel)
            && Objects.equals(type, that.type)
            && Objects.equals(uri, that.uri);
    }

}
