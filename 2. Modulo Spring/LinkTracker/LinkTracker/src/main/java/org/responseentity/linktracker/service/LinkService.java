package org.responseentity.linktracker.service;

import org.responseentity.linktracker.dto.LinkDTO;
import org.responseentity.linktracker.dto.LinkInvalidateDTO;
import org.responseentity.linktracker.dto.LinkMetricDTO;

import java.util.List;
import java.util.UUID;

public interface LinkService {
    LinkDTO insertLink(String subPath);
    List<LinkDTO> getAllTheLinks();
    LinkDTO getLinkById(UUID id);
    LinkMetricDTO getMetricsOfVideoById(UUID id);
    LinkInvalidateDTO invalidatesLinkById(UUID id, String pass);
}
