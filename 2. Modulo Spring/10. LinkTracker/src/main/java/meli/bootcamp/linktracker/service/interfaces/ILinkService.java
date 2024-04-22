package meli.bootcamp.linktracker.service.interfaces;

import meli.bootcamp.linktracker.dto.LinkRequestDTO;
import meli.bootcamp.linktracker.dto.LinkMetricsDTO;
import meli.bootcamp.linktracker.dto.NewLinkDTO;
import meli.bootcamp.linktracker.dto.LinkResponseDTO;

public interface ILinkService {
    NewLinkDTO createLink(LinkRequestDTO linkRequestDTO);
    LinkResponseDTO redirect(Integer id, String password);
    LinkMetricsDTO getMetricsLink(Integer id);
    void invalidateLink(Integer id);
}
