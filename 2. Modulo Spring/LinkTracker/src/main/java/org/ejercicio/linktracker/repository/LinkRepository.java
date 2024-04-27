package org.ejercicio.linktracker.repository;

import org.ejercicio.linktracker.entity.Link;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Repository
public class LinkRepository implements ILinkRepository {

    private Map<UUID, Link> links;

    public LinkRepository() {
        this.links = new HashMap<>();
    }

    @Override
    public Link findById(UUID id) {
        return links.get(id);
    }

    @Override
    public Link save(Link link) {
        links.put(link.getId(), link);
        return link;
    }
}
