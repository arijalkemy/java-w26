package co.com.mercadolibre.link_tracker.repository;

import co.com.mercadolibre.link_tracker.entity.Link;

import java.util.Optional;

public interface ILinkRepository {

    Optional<Link> save(Link link);
    Optional<Link> findById(Integer id);
    void invalidate(Integer id);
}
