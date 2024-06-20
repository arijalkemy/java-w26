package org.example.linktracker.repository;

import org.example.linktracker.model.Link;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class LinkRepository {

    private final Map<Integer, Link> linkStorage = new HashMap<>();
    private int currentId = 1;

    public Link save(Link link) {
        link.setId(currentId++);
        linkStorage.put(link.getId(), link);
        return link;
    }

    public Link findById(Integer id) {
        return linkStorage.get(id);
    }

    public List<Link> findAll() {
        return linkStorage.values().stream().collect(Collectors.toList());
    }

    public boolean existsById(Integer id) {
        return linkStorage.containsKey(id);
    }

    public void invalidate(Integer id) {
        Link link = linkStorage.get(id);
        if (link != null) {
            link.setValid(false);
        }
    }

    public void incrementRedirectCount(Integer id) {
        Link link = linkStorage.get(id);
        if (link != null) {
            link.setRedirectCount(link.getRedirectCount() + 1);
        }
    }
}
