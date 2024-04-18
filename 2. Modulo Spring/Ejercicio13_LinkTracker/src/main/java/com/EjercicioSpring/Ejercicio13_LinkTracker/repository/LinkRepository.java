package com.EjercicioSpring.Ejercicio13_LinkTracker.repository;

import com.EjercicioSpring.Ejercicio13_LinkTracker.entity.Link;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class LinkRepository implements ILinkRepository {

    public List<Link> links;

    public LinkRepository() {
        links = new ArrayList<>();
    }

    @Override
    public boolean addLink(Link link) {
        boolean linkExist = links.stream().anyMatch(x -> x.getOriginalUrl().equals(link.getOriginalUrl()));
        if (linkExist) {
            return false;
        }
        links.add(link);
        return true;
    }

    @Override
    public Link getLinkById(Integer linkId) {
        return links.stream().filter(x -> x.getLinkId().equals(linkId)).findFirst().orElse(null);
    }

    @Override
    public boolean updateValidationLink(Link link) {
        Link linkActual = links.stream().filter(x -> x.getLinkId().equals(link.getLinkId())).findFirst().orElse(null);
        if (linkActual == null) {
            return false;
        }
        if (linkActual.isValid()) {
            linkActual.setValid(false);
        } else {
            linkActual.setValid(true);
        }
        return true;
    }

    @Override
    public boolean updateCount(Integer linkId) {
        Link linkActual = links.stream().filter(x -> x.getLinkId().equals(linkId)).findFirst().orElse(null);
        if (linkActual == null) {
            return false;
        }
        linkActual.increaseCounter();
        return true;
    }

    @Override
    public int getSize() {
        return links.size();
    }
}
