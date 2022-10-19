package com.poc.level3.hateos;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class HateosSupport {

    private List<Link> links = new ArrayList<>();

    public List<Link> getLinks() {
        return links;
    }

	@Override
	public int hashCode() {
		return Objects.hash(links);
	}

	@Override
	public boolean equals(Object that) {
		if (this == that)
			return true;
		if (that == null)
			return false;
		if (getClass() != that.getClass())
			return false;
		HateosSupport other = (HateosSupport) that;
		return Objects.equals(links, other.links);
	}

}
