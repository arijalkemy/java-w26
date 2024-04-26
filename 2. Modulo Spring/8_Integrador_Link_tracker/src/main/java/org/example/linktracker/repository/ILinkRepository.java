package org.example.linktracker.repository;

import org.example.linktracker.model.Link;

import java.util.Optional;

public interface ILinkRepository {

    Optional<Link> findById(String linkId);

    void save(Link link);

    void delete(String linkId);
}
