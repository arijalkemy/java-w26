package org.bootcamp.linkTracker.repository;

import org.bootcamp.linkTracker.entity.Link;

public interface ILinkTrackerRepository {
    public Link saveLink(Link link);
    public Link findLinkById(String id);
    public Link findLinkByValue(String value);
    public boolean deleteLinkById(String id);
}
