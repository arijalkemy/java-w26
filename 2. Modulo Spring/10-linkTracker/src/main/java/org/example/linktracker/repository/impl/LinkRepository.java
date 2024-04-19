package org.example.linktracker.repository.impl;

import org.example.linktracker.model.Link;
import org.example.linktracker.repository.IRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class LinkRepository implements IRepository {

    private List<Link> listLinks;

    public LinkRepository() {
        listLinks = new ArrayList<>();
    }

    @Override
    public void add(Link link) {
        listLinks.add(link);
    }

    @Override
    public Link findById(String id) {
        return listLinks.stream().filter(l -> l.getId().equalsIgnoreCase(id)).findFirst().orElse(null);
    }

    @Override
    public void update(Link link) {
        int index = listLinks.indexOf(link);
        listLinks.set(index, link);
    }

    @Override
    public void delete(Link link) {
        listLinks.remove(link);
    }

}
