package com.poc.level3.hateos;

import java.util.ArrayList;
import java.util.List;

public class HateosSupport {

    private final List<Link> links;

    public HateosSupport() {
        links = new ArrayList<>();
    }

    public void addLink(Link link) {
        links.add(link);
    }

    public List<Link> getLinks() {
        return links;
    }

}
