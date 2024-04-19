package co.com.mercadolibre.link_tracker.repository.impl;

import co.com.mercadolibre.link_tracker.entity.Link;
import co.com.mercadolibre.link_tracker.repository.ILinkRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class LinkRepository implements ILinkRepository {

    private List<Link> links = new ArrayList<>();

    @Override
    public Optional<Link> save(Link link) {
        links.add(link);
        return Optional.of(link);
    }

    @Override
    public Optional<Link> findById(Integer id) {
        Optional<Link> link = links.stream().filter(link1 -> link1.getId().equals(id))
                .findFirst();
        return link;
    }

    @Override
    public void invalidate(Integer id) {
        Optional<Link> link = findById(id);
        if (link.isPresent()) {
            link.get().setValid(false);
            links.set(link.get().getId(), link.get());
        }
    }
}
