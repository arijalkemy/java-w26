package org.practicaspring.links.repository;

import org.practicaspring.links.model.Link;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class LinkRepositoryImpl implements ILinkRepository{
    private Map<Long, Link> linkMap = new HashMap<>();
    private Map<Long, Integer> accesses = new HashMap<>();

    @Override
    public Long add(Link link) {
        linkMap.put(link.getId(), link);
        accesses.put(link.getId(), 0);
        return link.getId();
    }

    @Override
    public Link findLink(Long linkId, String password) {
        Link link = linkMap.get(linkId);
        if (link == null ||(link.getPassword() != null && !link.getPassword().equals(password))) {
            return null;
        }
        accesses.put(linkId, accesses.get(linkId) + 1);
        return link;
    }

    @Override
    public Integer getMetricsById(Long linkId) {
        return accesses.get(linkId);
    }

    @Override
    public Link delete(Long id) {
        Link link = linkMap.get(id);
        linkMap.remove(id);
        accesses.remove(id);
        return link;
    }
}
