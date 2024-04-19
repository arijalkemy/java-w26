package com.meli.LinkTracker.repository;

import com.meli.LinkTracker.model.Link;

import java.util.Optional;

public interface ILinkRepository {
    void save(Link link);

    Optional<Link> findById(String id);
}
