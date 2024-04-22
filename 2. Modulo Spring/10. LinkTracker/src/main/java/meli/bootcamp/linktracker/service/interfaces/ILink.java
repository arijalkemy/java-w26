package meli.bootcamp.linktracker.service.interfaces;

import meli.bootcamp.linktracker.dto.RequestLinkDTO;
import meli.bootcamp.linktracker.dto.MetricsLinkDTO;
import meli.bootcamp.linktracker.dto.NewLinkDTO;
import meli.bootcamp.linktracker.dto.ResponseLinkDTO;

public interface ILink {
    NewLinkDTO createLink(RequestLinkDTO requestLinkDTO);
    ResponseLinkDTO redirect(Integer id, String password);
    MetricsLinkDTO getMetricsLink(Integer id);
    void invalidateLink(Integer id);
}
