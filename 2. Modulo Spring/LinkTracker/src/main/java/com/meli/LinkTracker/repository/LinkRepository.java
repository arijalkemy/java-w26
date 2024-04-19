package com.meli.LinkTracker.repository;

import com.meli.LinkTracker.model.Link;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class LinkRepository implements ILinkRepository{

    List<Link> links = new ArrayList<>();
    public void save(Link link){

    }

    @Override
    public Optional<Link> findById(String id) {
        return links.stream()
                .filter(l -> l.getId().equals(id))
                .findFirst();
    }
}
