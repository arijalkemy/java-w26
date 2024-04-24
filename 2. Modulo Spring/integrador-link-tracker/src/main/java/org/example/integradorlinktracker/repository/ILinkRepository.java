package org.example.integradorlinktracker.repository;

import org.example.integradorlinktracker.entity.Link;

public interface ILinkRepository {

    Link save(Link link);
    Link findById(int id);
    void delete(int id);
}
