package org.bootcamp.linkTracker.service.impl;

import org.bootcamp.linkTracker.dto.LinkRequestDTO;
import org.bootcamp.linkTracker.dto.LinkResponseDTO;
import org.bootcamp.linkTracker.entity.Link;
import org.bootcamp.linkTracker.exception.NonExistingResourceException;
import org.bootcamp.linkTracker.exception.NotAuthorizedException;
import org.bootcamp.linkTracker.repository.ILinkTrackerRepository;
import org.bootcamp.linkTracker.service.ILinkTrackerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LinkTrackerServiceImpl implements ILinkTrackerService {

    @Autowired
    private ILinkTrackerRepository linkTrackerRepository;

    @Override
    public LinkResponseDTO createLink(LinkRequestDTO link) {
        Link linkEntity = new Link(
                link.getPublicUrl(),
                link.getPassword()
                );
        
        Link savedLink = linkTrackerRepository.saveLink(linkEntity);

        LinkResponseDTO linkResponseDTO = new LinkResponseDTO();
        linkResponseDTO.setLinkId(savedLink.getLinkId());

        return linkResponseDTO;
    }

    @Override
    public String findLinkById(String id, Optional<String> pass) {
        Link l = linkTrackerRepository.findLinkById(id);
        if(l == null) throw new NonExistingResourceException("Link no encontrado");

        String password = l.getPassword();
        if (password != null) {
            if (pass.isPresent() && !password.equals(pass.get())) {
                throw new NotAuthorizedException("No tienes acceso");
            } else if (pass.isEmpty()) {
                throw new NotAuthorizedException("No tienes acceso");
            }
        }

        return l.getPublicUrl();
    }

    @Override
    public void incrementVisitCounter(String value) {
        Link l = linkTrackerRepository.findLinkByValue(value);
        if(l == null) throw new NonExistingResourceException("Link no encontrado");

        l.setTimesVisited(l.getTimesVisited() + 1);
    }

    @Override
    public Integer getVisitCounter(String id) {
        Link l = linkTrackerRepository.findLinkById(id);
        if(l == null) throw new NonExistingResourceException("Link no encontrado");

        return l.getTimesVisited();
    }

    @Override
    public String deleteLink(String id) {
        boolean isDeleted = linkTrackerRepository.deleteLinkById(id);
        if(!isDeleted) throw new NonExistingResourceException("Link no encontrado");

        return "Se eliminó el link correctamente";
    }
}
