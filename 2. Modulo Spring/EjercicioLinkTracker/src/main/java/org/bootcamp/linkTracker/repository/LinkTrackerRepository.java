package org.bootcamp.linkTracker.repository;

import org.bootcamp.linkTracker.entity.Link;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class LinkTrackerRepository implements ILinkTrackerRepository {
    private List<Link> links = new ArrayList<>();

    @Override
    public Link saveLink(Link link) {
        links.add(link);
        return link;
    }

    @Override
    public Link findLinkById(String id) {
        Link l = links.stream().filter(link -> link.getLinkId().equals(id)).findFirst().orElse(null);
        return l;
    }

    @Override
    public Link findLinkByValue(String value) {
        Link l = links.stream().filter(link -> link.getPublicUrl().equals(value)).findFirst().orElse(null);
        return l;
    }

    @Override
    public boolean deleteLinkById(String id) {
        return links.removeIf(link -> link.getLinkId().equals(id));
    }
}
