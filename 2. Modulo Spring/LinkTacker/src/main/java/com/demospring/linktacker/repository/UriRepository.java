package com.demospring.linktacker.repository;

import com.demospring.linktacker.entity.Link;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UriRepository  implements IUryRepository{
    private List<Link> links;
    private Map<Link, Integer> metrics;

    public UriRepository() {
        links = new ArrayList<>();
        metrics = new HashMap<>();
    }

    @Override
    public void addLink(Link link) {
        links.add(link);
        metrics.put(link, 0);
    }

    @Override
    public Link findLinkById(int id, boolean request) {
        Link link = links.stream().filter(l -> l.getId() == id).findFirst().orElse(null);
        if(link != null && request){
            incrementLink(link);
        }
        return link;
    }

    private void incrementLink(Link link) {
        metrics.put(link, metrics.get(link) + 1);
    }

    @Override
    public int metricsLink(int id) {
        return metrics.get(findLinkById(id, false));
    }

    @Override
    public void deleteLinkById(int id) {
        links.remove(findLinkById(id, false));
    }
}
