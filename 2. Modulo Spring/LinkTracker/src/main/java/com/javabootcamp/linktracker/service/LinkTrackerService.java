package com.javabootcamp.linktracker.service;

import com.javabootcamp.linktracker.dto.LinkDtoOut;
import com.javabootcamp.linktracker.exception.UrlAlreadyExistsException;
import com.javabootcamp.linktracker.exception.UrlNotFoundException;
import com.javabootcamp.linktracker.model.Link;
import com.javabootcamp.linktracker.repository.LinkTrackerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class LinkTrackerService {

    @Autowired
    LinkTrackerRepository linkTrackerRepository;


    // Crear un nuevo link o agregar al repositorio
    public int addLink(String linkUrl, String password) {
        Link link = createNewLink(linkUrl, password);
        while (linkTrackerRepository.findLink(link.getLinkId())){
            link.setLinkId(new Random().nextInt(10000));
        }
        linkTrackerRepository.addLink(link);
        return link.getLinkId();
    }

    private static Link createNewLink(String linkUrl, String password) {
        Link link = new Link(new Random().nextInt(10000),
                0,
                linkUrl,
                true,
                password);
        return link;
    }

    // Consultar un link
    public LinkDtoOut getMetricsLink(int linkId) {
        if (linkTrackerRepository.findLink(linkId)) {
            if (linkTrackerRepository.getLink(linkId).isActive()) {
                return new LinkDtoOut(linkTrackerRepository.getLink(linkId).getRedirectionCounter(),
                        linkTrackerRepository.getLink(linkId).getUrl());
            } else {
                throw new UrlNotFoundException("Url not found");
            }
        } else {
            throw new UrlNotFoundException("Url not found");
        }
    }

    // Invalidar un link
    public void invalidateLink(int linkId) {
        if (linkTrackerRepository.findLink(linkId)) {
            linkTrackerRepository.getLink(linkId).setActive(false);
        } else {
            throw new UrlNotFoundException("Url not found");
        }
    }

    // Aumentar contador de redirecciones
    public void increaseRedirectionCounter(int linkId) {
        if (linkTrackerRepository.findLink(linkId)) {
            linkTrackerRepository.increaseRedirectionCounter(linkId);
        } else {
            throw new UrlNotFoundException("Url not found");
        }
    }

    // Redirigir a un link
    public String getRedirectLink(int linkId) {
        if (linkTrackerRepository.findLink(linkId)) {
            if (linkTrackerRepository.getLink(linkId).isActive()){
                linkTrackerRepository.increaseRedirectionCounter(linkId);
                return linkTrackerRepository.getLink(linkId).getUrl();
            }
            throw new UrlNotFoundException("Url not found");
        }
        throw new UrlNotFoundException("Url not found");
    }



}
