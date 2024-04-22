package com.ejercicio.linktracker.repository.implementations;

import com.ejercicio.linktracker.entity.Link;
import com.ejercicio.linktracker.repository.interfaces.ILinkRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class LinkRepository implements ILinkRepository {
    private List<Link> linkList;

    public LinkRepository() {
        this.linkList = new ArrayList<Link>();
    }

    @Override
    public Link add(Link link) {
        linkList.add(link);
        return link;
    }

    @Override
    public Link get(int linkId) {
        Optional<Link> result = linkList
                .stream()
                .filter(link -> link.getId() == linkId)
                .findFirst();

        if(result.isPresent()) return result.get();
        return null;
    }

    @Override
    public void update(Link link) {
        int index = linkList.indexOf(link);
        linkList.set(index, link);
    }
}
