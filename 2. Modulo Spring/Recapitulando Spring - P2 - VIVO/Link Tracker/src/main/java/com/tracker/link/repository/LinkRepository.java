package com.tracker.link.repository;

import com.tracker.link.entity.Contador;
import com.tracker.link.entity.Link;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LinkRepository implements ILinkRepository{
    private HashMap<Integer, Link> links = new HashMap<>();

    public LinkRepository() {
        links.put(1,new Link("https://www.google.com", "www.google.com",null,true));
        links.put(2,new Link("https://www.facebook.com", "www.facebook.com",null,true));
        links.put(3,new Link("https://www.twitter.com", "www.twitter.com",null,true));
    }

    public HashMap<Integer, Link> findAll() {
        return links;
    }

    public void addLink(int id, Link link) {
        links.put(id, link);
    }

    public Link findLink(int id) {
        return links.get(id);
    }
}
