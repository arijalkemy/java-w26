package org.example.link_tracer.repository;

import org.example.link_tracer.model.Link;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class LinkRepository implements ILinkRepository {
    private final List<Link> linkList =new ArrayList<>();

    @Override
    public Link save(Link newLink) {
        if(newLink.getId()==null){
            newLink.setId(linkList.size()+1);
            this.linkList.add(newLink);
        }
        else {
            this.linkList.set(newLink.getId()-1,newLink);
        }
        return newLink;
    }
    @Override
    public Optional<Link> findById(Integer id) {
        return linkList.stream()
                .filter(x->
                        x.getId().equals(id))
                .findFirst();
    }

    @Override
    public List<Link> findAll() {
        return this.linkList;
    }
}
