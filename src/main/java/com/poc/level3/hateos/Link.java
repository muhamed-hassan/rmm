package com.poc.level3.hateos;

public class Link {

    public static final String SELF = "self";

    public enum type {
        GET,
        POST,
        DELETE,
        PUT
    };

    private final String uri;

    private final String rel;

    private final String type;

    public Link(String uri, String rel, String type) {
        this.uri = uri;
        this.rel = rel;
        this.type = type;
    }

    public String getUri() {
        return uri;
    }

    public String getRel() {
        return rel;
    }

    public String getType() {
        return type;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((rel == null) ? 0 : rel.hashCode());
        result = prime * result + ((type == null) ? 0 : type.hashCode());
        result = prime * result + ((uri == null) ? 0 : uri.hashCode());
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
        Link other = (Link) obj;
        if (rel == null) {
            if (other.rel != null)
                return false;
        } else if (!rel.equals(other.rel))
            return false;
        if (type == null) {
            if (other.type != null)
                return false;
        } else if (!type.equals(other.type))
            return false;
        if (uri == null) {
            if (other.uri != null)
                return false;
        } else if (!uri.equals(other.uri))
            return false;
        return true;
    }

}
