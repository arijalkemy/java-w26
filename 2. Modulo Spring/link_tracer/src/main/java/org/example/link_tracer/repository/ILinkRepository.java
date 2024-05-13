package org.example.link_tracer.repository;

import org.example.link_tracer.model.Link;

import java.util.*;

public interface ILinkRepository {
    Link save(Link newLink);
    Optional<Link> findById(Integer id);
    List<Link> findAll();
}
