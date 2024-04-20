package org.responseentity.linktracker.repository;

import org.responseentity.linktracker.dto.LinkDTO;
import org.responseentity.linktracker.entity.LinkEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class LinkResposity {
    private List<LinkEntity> links;
    public LinkResposity() {
        this.links = new ArrayList<>();
    }

    public void insertLink(LinkEntity linkEntity){
        linkEntity.setId(UUID.randomUUID());
        links.add(linkEntity);
    }

    public List<LinkEntity> getAllTheLink(){
        return links;
    }

    public Optional<LinkEntity> getLinkById(UUID id){
        return links.stream()
                .filter(x -> x.getId().equals(id) && x.getStatus().equals(true))
                .findFirst();
    }

    public void addRedirectToLink(UUID id){
        links.stream()
                .filter(link -> link.getId().equals(id) && link.getStatus().equals(true))
                .findFirst()
                .ifPresent(link -> link.setNumberOfRedirects(link.getNumberOfRedirects() + 1));
    }

    public void invalidateLink(UUID id){
        for(LinkEntity link: links){
            if(link.getId().equals(id)){
                link.setStatus(false);
                return;
            }
        }
    }
}
