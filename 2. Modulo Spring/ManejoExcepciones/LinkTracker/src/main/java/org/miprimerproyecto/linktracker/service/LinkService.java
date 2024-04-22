package org.miprimerproyecto.linktracker.service;

import org.miprimerproyecto.linktracker.dto.LinkDTO;
import org.miprimerproyecto.linktracker.dto.MetricsDTO;
import org.miprimerproyecto.linktracker.repository.LinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LinkService implements ILinkService{

    @Autowired
    LinkRepository linkRepository;

    @Override
    public LinkDTO createLink(String originalUrl, String password) {
        LinkDTO link = new LinkDTO();
        link.setOriginalUrl(originalUrl);
        link.setPassword(password);
        return linkRepository.saveLink(link);
    }

    @Override
    public boolean validateLink(String linkId, String password) {
        LinkDTO link= linkRepository.findLinkById(linkId);
        return link != null && link.isValid() && (password==null || password.equals(link.getPassword()));
    }

    @Override
    public String getOriginalUrl(String linkId) {
        LinkDTO link = linkRepository.findLinkById(linkId);
        return link !=null && link.isValid() ? link.getOriginalUrl(): null;
    }

    @Override
    public MetricsDTO getLinkMetrics(String linkId) {
        LinkDTO link = linkRepository.findLinkById(linkId);
        MetricsDTO metricsDTO = new MetricsDTO();
        metricsDTO.setLinkId(linkId);
        metricsDTO.setRedirectionCount(link != null && link.isValid() ? 1 : 0);
        return metricsDTO;
    }

    @Override
    public void invalidateLink(String linkId) {
        linkRepository.invalidateLink(linkId);
    }
}
