package org.example.integradorlinktracker.repository.impl;


import org.example.integradorlinktracker.entity.Link;
import org.example.integradorlinktracker.repository.ILinkRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class LinkRepositoryImpl implements ILinkRepository {
    private final Map<Integer, Link> linkMap = new HashMap<>();
    private int nextId = 1;

    @Override
    public Link save(Link link) {
        link.setId(nextId++);
        linkMap.put(link.getId(), link);
        return link;
    }

    @Override
    public Link findById(int id) {
        return linkMap.get(id);
    }

    @Override
    public void delete(int id) {
        linkMap.remove(id);
    }
}