package com.tracker.link.service.impl;

import com.tracker.link.dto.ContadorResponseDTO;
import com.tracker.link.dto.LinkResponseDTO;
import com.tracker.link.entity.Contador;
import com.tracker.link.entity.Link;
import com.tracker.link.repository.LinkRepository;
import com.tracker.link.service.ILinkService;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.*;

public class LinkService implements ILinkService {
    LinkRepository linkRepository = new LinkRepository();
    private Contador contador = new Contador();


    @Override
    public List<LinkResponseDTO> allLinks() {
        HashMap<Integer, Link> links = linkRepository.findAll();
        return convertToDTO(links);
    }

    public List<LinkResponseDTO> convertToDTO(HashMap<Integer, Link> links) {
        List<LinkResponseDTO> linkDTOs = new ArrayList<>();
        for (Map.Entry<Integer, Link> entry : links.entrySet()) {
            linkDTOs.add(new LinkResponseDTO(entry.getKey()));
        }
        return linkDTOs;
    }

    @Override
    public LinkResponseDTO createLink(String url, String password) {
        HashMap<Integer, Link> links = linkRepository.findAll();
        int newId = links.size() + 1;
        Link newLink = new Link(url, UUID.randomUUID().toString(), password, true);
        linkRepository.addLink(newId, newLink);
        contador.getContador().put(newId, 0);
        return new LinkResponseDTO(newId);
    }

    @Override
    public String getLink(int id){
        Link link = linkRepository.findLink(id);
        if (link != null && link.isValid()) {
              contador.getContador().put(id, contador.getContador().get(id) + 1);

            return link.getPublicURL();
        }
        return null;
    }

    @Override
    public ContadorResponseDTO getMetrics(int linkID) {
        return new ContadorResponseDTO(contador.getContador().get(linkID));
    }

    @Override
    public String invalidate(int linkid) {
        Link link = linkRepository.findLink(linkid);
        if (link != null) {
            link.setValid(false);
            return "Link invalidated";
        }
        return "Link not found";
    }


}
