package org.miprimerproyecto.linktracker.repository;

import org.miprimerproyecto.linktracker.dto.LinkDTO;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class LinkRepository implements ILinkRepository{

    private final List<LinkDTO> links= new ArrayList<>();

    @Override
    public List<LinkDTO> getAllLinks() {
        return this.links;
    }

    @Override
    public LinkDTO saveLink(LinkDTO link) {
        link.setLinkId("https://mercadolibre.com");
        this.links.add(link);
        return link;
    }

    @Override
    public LinkDTO findLinkById(String linkId) {
        return this.links.stream()
                .filter(link -> link.getLinkId().equals(linkId))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void invalidateLink(String linkId) {
        this.links.stream()
                .filter(link -> link.getLinkId().equals(linkId))
                .findFirst()
                .ifPresent(link -> link.setValid(false));

    }
}
