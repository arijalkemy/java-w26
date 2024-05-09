package org.bootcamp.linktracker.repository;

import org.bootcamp.linktracker.model.Link;

import java.util.Optional;

public interface ILinkRepository {
    void save(Link link);

    Optional<Link> findLinkByLinkId(Integer linkId);

    void delete(Link link);
}
