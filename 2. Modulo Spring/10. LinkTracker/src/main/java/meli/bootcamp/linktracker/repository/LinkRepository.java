package meli.bootcamp.linktracker.repository;

import meli.bootcamp.linktracker.entity.Link;
import meli.bootcamp.linktracker.repository.interfaces.ICrud;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class LinkRepository implements ICrud<Link> {

    List<Link> links = new ArrayList<>();

    @Override
    public void save(Link link) {
        links.add(link);
    }

    @Override
    public Link findById(Integer id) {
        return links.stream()
                .filter(link -> link.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Link> findAll() {
        return links;
    }
}
