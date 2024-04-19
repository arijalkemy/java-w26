package com.spring.linktracker.repository;

import com.spring.linktracker.entity.Link;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class LinksRepository implements ICRUD<Link> {

    private List<Link> linksRepository;

    public LinksRepository() {
        this.linksRepository = new ArrayList<>();
    }

    @Override
    public void create(Link obj) {
        this.linksRepository.add(obj);
    }

    @Override
    public Link search(Integer id) {
        return this.linksRepository
                .stream()
                .filter(v -> v.getLinkId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void update(Link obj) {

    }

    @Override
    public void delete(Integer id) {
        this.linksRepository.removeIf(v -> v.getLinkId().equals(id));
    }

    @Override
    public List<Link> getAll() {
        return this.linksRepository;
    }
}
