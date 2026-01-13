package com.poc.level3.hateos;

import java.util.Objects;

public class EndpointURI {

    private HttpMethod httpMethod;

    private String uri;
    
	public HttpMethod getHttpMethod() {
		return httpMethod;
	}

	public void setHttpMethod(HttpMethod httpMethod) {
		this.httpMethod = httpMethod;
	}
	
	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	@Override
	public int hashCode() {
		return Objects.hash(httpMethod, uri);
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
		EndpointURI other = (EndpointURI) object;
		return httpMethod == other.httpMethod && 
				Objects.equals(uri, other.uri);
	}

}
