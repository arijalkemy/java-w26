package org.example.linktracker.repository;

import org.example.linktracker.model.Link;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public class LinkRepository implements ILinkRepository {

    private final Map<String, Link> linkMap;

    public LinkRepository() {
        linkMap = new HashMap<>();
    }


    @Override
    public void save(Link link) {
        linkMap.put(link.getLinkId(), link);
    }

    @Override
    public Optional<Link> findById(String linkId) {
        return Optional.ofNullable(linkMap.get(linkId));
    }

    @Override
    public void delete(String linkId) {
        linkMap.remove(linkId);
    }
}
