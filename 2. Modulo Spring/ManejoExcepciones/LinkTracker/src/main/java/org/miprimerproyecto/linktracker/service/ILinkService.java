package org.miprimerproyecto.linktracker.service;

import org.miprimerproyecto.linktracker.dto.LinkDTO;
import org.miprimerproyecto.linktracker.dto.MetricsDTO;

public interface ILinkService {
    LinkDTO createLink(String originalUrl, String password);
    boolean validateLink(String linkId, String password);
    String getOriginalUrl(String linkId);
    MetricsDTO getLinkMetrics(String linkId);
    void invalidateLink(String linkId);
}
