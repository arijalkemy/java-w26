package com.link.tracker.repository;

import com.link.tracker.dto.LinkDTO;

import java.util.Optional;

public interface LinkRepository {

    LinkDTO save(LinkDTO link);

    Optional<LinkDTO> findLinkByLinkId(Integer linkId);

    void delete(LinkDTO linkDTO);
}
