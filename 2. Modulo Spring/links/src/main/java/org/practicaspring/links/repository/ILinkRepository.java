package org.practicaspring.links.repository;

import org.practicaspring.links.model.Link;

public interface ILinkRepository {
    Long add(Link link);

    Link findLink(Long linkId, String password);

    Integer getMetricsById(Long linkId);

    Link delete(Long id);
}
