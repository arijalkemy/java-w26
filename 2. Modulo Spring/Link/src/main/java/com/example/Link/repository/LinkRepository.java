package com.example.Link.repository;

import com.example.Link.entity.Link;
import java.util.HashMap;
import java.util.Map;

public class LinkRepository implements IlinkRepository {
    private Map<Integer, Link> storage = new HashMap<>();
    private int idCounter = 0;

    @Override
    public Link save(Link link) {
        if (link.getId() == null) {
            link.setId(++idCounter);  // Ensure IDs are unique and incremented.
        }
        storage.put(link.getId(), link);
        return link;
    }

    @Override
    public Link findById(Integer id) {
        return storage.get(id);
    }

    @Override
    public void invalidate(Integer id) {
        if (storage.containsKey(id)) {
            Link link = storage.get(id);
            link.setValid(false);  // Set the link as invalid.
        }
    }
}

