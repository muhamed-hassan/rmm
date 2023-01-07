package com.poc.level3.hateos;

import java.util.ArrayList;
import java.util.List;

public class HateosSupport {

    private List<Link> links = new ArrayList<Link>();

    protected void addLink(Link link) {
    	links.add(link);
    }
    
    public List<Link> getLinks() {
		return links;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((links == null) ? 0 : links.hashCode());
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
		if (links == null) {
			if (other.links != null)
				return false;
		} else if (!links.equals(other.links))
			return false;
		return true;
	}

}
