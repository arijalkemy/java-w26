package com.w26.linktracker.repository;

import com.w26.linktracker.entity.Link;
import lombok.Getter;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
@Getter
public class LinkRepository {
    private Map<Integer, Link> links;

    public LinkRepository()
    {
        this.links = new HashMap<>();
    }

    public void addLink(Integer id, Link link)
    {
        this.links.put(id, link);
    }

    public Link getLink(Integer id)
    {
        return this.links.get(id);
    }
}
