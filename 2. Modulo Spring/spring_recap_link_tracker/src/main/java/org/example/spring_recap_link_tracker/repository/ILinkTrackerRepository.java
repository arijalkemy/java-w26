package org.example.spring_recap_link_tracker.repository;

import org.example.spring_recap_link_tracker.entity.LinkTrack;

public interface ILinkTrackerRepository {
    public void createNewLink(LinkTrack linkTrack);
    public LinkTrack getLinkById(String linkId);
    public void updateLink(LinkTrack link);
}
