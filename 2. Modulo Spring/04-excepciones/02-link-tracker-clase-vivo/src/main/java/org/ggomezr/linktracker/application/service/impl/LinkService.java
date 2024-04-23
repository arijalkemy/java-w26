package org.ggomezr.linktracker.application.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.ggomezr.linktracker.application.service.interfaces.ILinkService;
import org.ggomezr.linktracker.domain.dto.LinkDTO;
import org.ggomezr.linktracker.domain.dto.MetricsDTO;
import org.ggomezr.linktracker.domain.entity.Link;
import org.ggomezr.linktracker.domain.exception.LinkNotFoundException;
import org.ggomezr.linktracker.domain.repository.impl.LinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class LinkService implements ILinkService {

    @Autowired
    private LinkRepository linkRepository;

    ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public String createLink(LinkDTO linkDTO) {
        String linkId = UUID.randomUUID().toString();
        Link link = new Link();
        link.setLinkId(linkId);
        link.setUrl(linkDTO.getUrl());
        link.setPassword(linkDTO.getPassword());
        link.setRedirectionCount(0);
        link.setValid(true);
        linkRepository.save(link);
        return linkId;
    }

    @Override
    public String redirect(String linkId, String password) {
        Link link = linkRepository.findById(linkId);
        if (link != null && link.isValid() && (link.getPassword() == null || link.getPassword().equals(password))) {
            link.setRedirectionCount(link.getRedirectionCount() + 1);
            linkRepository.save(link);
            return link.getUrl();
        } else {
            throw new LinkNotFoundException("Link no encontrado");
        }
    }

    @Override
    public MetricsDTO getMetrics(String linkId) {
        Link link = linkRepository.findById(linkId);
        if (link != null) {
            return new MetricsDTO(link.getRedirectionCount());
        } else {
            throw new LinkNotFoundException("Link no encontrado");
        }
    }

    @Override
    public String invalidateLink(String linkId) {
        linkRepository.invalidate(linkId);
        return "Link invalidado";
    }

    @Override
    public List<LinkDTO> getAllLinks() {
        return linkRepository.findAll().stream()
                .map(link -> objectMapper.convertValue(link, LinkDTO.class)).toList();
    }
}