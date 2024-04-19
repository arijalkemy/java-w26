package org.example.linktracker.repository;

import org.example.linktracker.model.Link;

public interface IRepository {
    void add(Link link);
    Link findById(String id);
    void update(Link link);
    void delete(Link link);
}
