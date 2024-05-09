package org.bootcamp.linktracker.repository;

import org.bootcamp.linktracker.model.Link;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public class LinkRepositoryImpl implements ILinkRepository {
    private final Map<Integer, Link> links = new HashMap<>();

    @Override
    public void save(Link link) {
        links.put(link.getLinkId(), link);
    }

    @Override
    public Optional<Link> findLinkByLinkId(Integer linkId) {
        return Optional.ofNullable(links.get(linkId));
    }

    @Override
    public void delete(Link link) {
        links.remove(link.getLinkId());
    }
}
