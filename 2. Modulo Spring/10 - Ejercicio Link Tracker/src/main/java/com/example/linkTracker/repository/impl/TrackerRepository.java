package com.example.linkTracker.repository.impl;

import com.example.linkTracker.model.Link;
import com.example.linkTracker.repository.ITrackerRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TrackerRepository implements ITrackerRepository {
    List<Link> links = new ArrayList<>();

    @Override
    public List<Link> getAll() {
        return links;
    }

    @Override
    public Link findById(String id) {

        return links.stream().filter( x -> x.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public void save(Link link) {
        links.add(link);
    }

    @Override
    public boolean sumRedirect(String id) {
        Link link = links.stream().filter( x -> x.getId().equals(id)).findFirst().orElse(null);

        if( link == null ) return false;

        link.setAccessCounter( link.getAccessCounter() + 1 );
        return true;
    }

    @Override
    public boolean invalidateLink(String id) {
        Link link = links.stream().filter( x -> x.getId().equals(id)).findFirst().orElse(null);

        if( link == null ) return false;

        link.setValid( false );
        return true;
    }
}
