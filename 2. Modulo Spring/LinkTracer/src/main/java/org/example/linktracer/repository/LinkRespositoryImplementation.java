package org.example.linktracer.repository;

import org.example.linktracer.entity.Link;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


@Repository
public class LinkRespositoryImplementation implements ILinkRepository {


    HashMap<UUID, Link> links;



    LinkRespositoryImplementation() {
        links = new HashMap<>();
    }


    @Override
    public boolean validateLink(String linkId) {
        return links.containsKey(UUID.fromString(linkId));
    }

    @Override
    public String invalidateLink(String linkId) {
        links.remove(UUID.fromString(linkId));
        return "Link invalidated";
    }

    @Override
    public Link getMetrics(String linkId) {
        return links.get(UUID.fromString(linkId));
    }

    @Override
    public void incrementLinkCounter(String linkId) {
        for (Map.Entry<UUID, Link> entry : links.entrySet()) {
            if (entry.getKey().equals(UUID.fromString(linkId))) {
                entry.getValue().setRedirectCounter(entry.getValue().getRedirectCounter() + 1);
            }
        }
    }

    @Override
    public Link generateLinkId(String password) {
        UUID uuid = UUID.randomUUID();
        Link link = new Link(uuid, 0, password);
        links.put(uuid, link);
        return link;
    }
}
