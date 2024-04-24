package org.example.integradorlinktracker.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.integradorlinktracker.dto.LinkDto;
import org.example.integradorlinktracker.dto.LinkMetricsDto;
import org.example.integradorlinktracker.entity.Link;
import org.example.integradorlinktracker.entity.LinkRedirect;
import org.example.integradorlinktracker.exceptions.BadRequestException;
import org.example.integradorlinktracker.exceptions.NotFoundException;
import org.example.integradorlinktracker.repository.impl.LinkRepositoryImpl;
import org.example.integradorlinktracker.service.ILinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class LinkServiceImpl implements ILinkService<LinkDto> {
    private final LinkRepositoryImpl linkRepository;

    @Autowired
    public LinkServiceImpl(LinkRepositoryImpl linkRepository) {
        this.linkRepository = linkRepository;
    }

    @Override
    public Link createLink(LinkDto linkDto) {
        Link link = new Link();
        link.setUrl(linkDto.getUrl());
        link.setPassword(linkDto.getPassword());
        return linkRepository.save(link);
    }

    @Override
    public Link redirect(int linkId, String password) {
        Link link = linkRepository.findById(linkId);
        if (link == null) {
            throw new NotFoundException("El enlace no fue encontrado");
        }
        if (!Objects.equals(link.getPassword(), password)) {
            throw new BadRequestException("Contraseña incorrecta");
        }
        link.setRedirectCount(link.getRedirectCount() + 1);
        return link;
    }

    @Override
    public LinkMetricsDto getLinkMetrics(int linkId) {
        Link link = linkRepository.findById(linkId);
        if (link == null) {
            throw new NotFoundException("El enlace no fue encontrado");
        }
        LinkMetricsDto metricsDto = new LinkMetricsDto();
        metricsDto.setRedirectCount(link.getRedirectCount());
        return metricsDto;
    }

    @Override
    public void invalidateLink(int linkId) {
        linkRepository.delete(linkId);
    }
}