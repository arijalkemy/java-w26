package org.ggomezr.linktracker.domain.repository.impl;

import org.ggomezr.linktracker.domain.entity.Link;
import org.ggomezr.linktracker.domain.repository.interfaces.ILinkRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class LinkRepository implements ILinkRepository {

    List<Link> links = new ArrayList<>();

    @Override
    public Link save(Link link) {
        links.add(link);
        return link;
    }

    @Override
    public Link findById(String linkId) {
        for (Link link : links) {
            if (link.getLinkId().equals(linkId)) {
                return link;
            }
        }
        return null;
    }

    @Override
    public void invalidate(String linkId) {
        for (Link link : links) {
            if (link.getLinkId().equals(linkId)) {
                link.setValid(false);
                break;
            }
        }
    }

    @Override
    public List<Link> findAll() {
        return links;
    }
}
