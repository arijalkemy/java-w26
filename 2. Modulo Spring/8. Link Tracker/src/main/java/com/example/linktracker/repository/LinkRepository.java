package com.example.linktracker.repository;

import com.example.linktracker.dto.LinkDTO;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public class LinkRepository {
    private final Map<Integer, LinkDTO> links = new HashMap<>();

    public LinkDTO save(LinkDTO link) {
        if (link.getLinkId() == null)
            link.setLinkId(links.values().size());
        links.put(link.getLinkId(), link);
        return link;
    }

    public Optional<LinkDTO> findLinkByLinkId(Integer linkId) {
        LinkDTO linkDTO = links.get(linkId);
        return Optional.ofNullable(linkDTO);
    }

    public void delete(LinkDTO linkDTO) {
        links.remove(linkDTO.getLinkId());
    }



}
