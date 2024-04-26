package org.example.linktracer.repository;

import org.example.linktracer.entity.Link;

public interface ILinkRepository {
    Link generateLinkId(String password);
    boolean validateLink(String linkId);
    void incrementLinkCounter(String linkId);
    Link getMetrics(String linkId);
    String invalidateLink (String link);
}
