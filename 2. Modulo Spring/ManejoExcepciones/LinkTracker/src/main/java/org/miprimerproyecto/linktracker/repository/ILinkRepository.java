package org.miprimerproyecto.linktracker.repository;

import org.miprimerproyecto.linktracker.dto.LinkDTO;

import java.util.List;

public interface ILinkRepository {
    List<LinkDTO> getAllLinks();

    LinkDTO saveLink(LinkDTO link);

    LinkDTO findLinkById(String linkId);

    void invalidateLink(String linkId);
}
