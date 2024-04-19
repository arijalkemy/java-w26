package com.spring.linktracker.service;

import com.spring.linktracker.dto.LinkRequestDTO;
import com.spring.linktracker.dto.LinkResponseDTO;
import com.spring.linktracker.entity.Link;
import com.spring.linktracker.exception.ForbiddenException;
import com.spring.linktracker.exception.NotFoundException;
import com.spring.linktracker.exception.UnauthorizedException;
import com.spring.linktracker.repository.LinksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LinksService implements ILinksService {

    @Autowired
    LinksRepository linkRepository;

    @Override
    public LinkResponseDTO createLink(LinkRequestDTO linkRequest, String password) {
        Link newLink = new Link(linkRequest.getUrl(), password, 0, true);
        this.linkRepository.create(newLink);
        return new LinkResponseDTO(newLink.getLinkId());
    }

    @Override
    public String redirectLink(Integer linkId, String password) {
        Link foundLink = this.linkRepository.search(linkId);
        if (foundLink == null) {
            throw new NotFoundException("Link not found");
        }
        if (!foundLink.getIsValid()) {
            throw new ForbiddenException("Acceso restringido");
        }
        if (foundLink.getPassword() == null || foundLink.getPassword().equals(password)) {
            this.addVisit(linkId);
            return foundLink.getUrl();
        }
        throw new UnauthorizedException("Wrong password");
    }

    @Override
    public Integer getLinkMetrics(Integer linkId) {
        Link foundLink = this.linkRepository.search(linkId);
        if (foundLink == null) {
            throw new NotFoundException("Link not found");
        }
        return this.linkRepository.search(linkId).getTimesRedirected();
    }

    @Override
    public void invalidateLink(Integer linkId) {
        this.invalidateLinkAccess(linkId);
    }

    private void addVisit(Integer linkId) {
        this.linkRepository.getAll().forEach(p -> {
            if (p.getLinkId().equals(linkId)) {
                p.setTimesRedirected(p.getTimesRedirected() + 1);
            }
        });
    }

    private void invalidateLinkAccess(Integer linkId) {
        this.linkRepository.getAll().forEach(p -> {
            if (p.getLinkId().equals(linkId)) {
                p.setIsValid(false);
            }
        });
    }

}
