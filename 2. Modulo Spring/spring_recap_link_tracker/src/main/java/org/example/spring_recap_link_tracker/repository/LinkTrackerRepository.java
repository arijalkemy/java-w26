package org.example.spring_recap_link_tracker.repository;

import lombok.Getter;
import org.example.spring_recap_link_tracker.entity.LinkTrack;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
@Getter
public class LinkTrackerRepository implements ILinkTrackerRepository{
    Map<String, LinkTrack> linkTrackMap;

    public LinkTrackerRepository() {
        this.linkTrackMap = new HashMap<>();
    }

    public void createNewLink(LinkTrack linkTrack) {
        linkTrackMap.put(linkTrack.getLinkId(), linkTrack);
    }

    public LinkTrack getLinkById(String linkId) {
        return linkTrackMap.get(linkId);
    }

    public void invalidateLink(LinkTrack link) {
        linkTrackMap.replace(link.getLinkId(), link);
    }
}
