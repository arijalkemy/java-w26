package org.bootcamp.recapitulando_spring_p2_link_tracer.repository;

import org.bootcamp.recapitulando_spring_p2_link_tracer.entity.Link;

import java.util.UUID;

public interface ILinkTrackerRepository {
    public Link saveLink(Link link);
    public Link findLinkById(String id);
    public Link findLinkByValue(String value);
    public boolean deleteLinkById(String id);
}
