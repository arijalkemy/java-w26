package org.ggomezr.linktracker.application.service.interfaces;

import org.ggomezr.linktracker.domain.dto.LinkDTO;
import org.ggomezr.linktracker.domain.dto.MetricsDTO;

import java.util.List;

public interface ILinkService {
    String createLink(LinkDTO linkDTO);
    String redirect(String linkId, String password);
    MetricsDTO getMetrics(String linkId);
    String invalidateLink(String linkId);

    List<LinkDTO> getAllLinks();
}
