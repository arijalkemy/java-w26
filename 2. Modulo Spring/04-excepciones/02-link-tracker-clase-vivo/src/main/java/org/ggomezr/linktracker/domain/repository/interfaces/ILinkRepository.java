package org.ggomezr.linktracker.domain.repository.interfaces;

import org.ggomezr.linktracker.domain.entity.Link;

import java.util.List;

public interface ILinkRepository {
    Link save(Link link);
    Link findById(String linkId);
    void invalidate(String linkId);
    List<Link> findAll();
}
