package bootcamp.bendezujonathan.link.repository.implementations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Repository;

import bootcamp.bendezujonathan.link.model.Link;
import bootcamp.bendezujonathan.link.repository.interfaces.ILinkRepository;

@Repository
public class LinkRepository implements ILinkRepository {

    private List<Link> links;

    LinkRepository() {
        this.links = new ArrayList<>();
    }

    @Override
    public void save(Link toSave) {
        this.links.add(toSave);
    }


    
    @Override
    public Optional<Link> findById(int id) {
        return this.links
                .stream()
                .filter(link -> link.getId() == id && link.isValid())
                .findFirst();
    }

    @Override
    public List<Link> findAll() {
        return this.links;
    }

    @Override
    public boolean exists(Link toCheck) {
        return this.links
                .stream()
                .anyMatch(link -> link.getUrl().equalsIgnoreCase(toCheck.getUrl()));
    }

    @Override
    public int getNextId() {
        return this.links.size() + 1;
    }

    @Override
    public void update(Link toUpdate) {
        Link founded = this.findById(toUpdate.getId()).get();
        founded.setValid(toUpdate.isValid());
        founded.setPassword(toUpdate.getPassword());
        founded.setUrl(toUpdate.getUrl());
    }

}
