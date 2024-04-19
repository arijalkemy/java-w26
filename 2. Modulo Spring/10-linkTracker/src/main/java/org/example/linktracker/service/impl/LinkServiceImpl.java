package org.example.linktracker.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletResponse;
import org.example.linktracker.dto.IdLinkDTO;
import org.example.linktracker.dto.LinkDTO;
import org.example.linktracker.exceptions.NotFoundException;
import org.example.linktracker.model.Link;
import org.example.linktracker.repository.IRepository;
import org.example.linktracker.service.ILinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class LinkServiceImpl implements ILinkService {

    @Autowired
    IRepository linkRepository;

    @Override
    public IdLinkDTO create(String url) {
        Link link = new Link(url);
        linkRepository.add(link);
        return new IdLinkDTO(link.getId());
    }

    @Override
    public IdLinkDTO create(String url, String password) {
        Link link = new Link(url, password);
        linkRepository.add(link);
        return new IdLinkDTO(link.getId());
    }

    @Override
    public void redirect(String id, HttpServletResponse response) throws IOException {
        Link link = linkRepository.findById(id);
        if (link != null){
            response.sendRedirect(link.getUrl());
            link.setCountRedirect(link.getCountRedirect() + 1);
            linkRepository.update(link);
        } else {
            throw new NotFoundException("No se encontro el link con ese id");
        }
    }

    @Override
    public LinkDTO getCantRedirects(String id) {
        Link link = linkRepository.findById(id);
        LinkDTO linkDto;
        if (link != null) {
            ObjectMapper mapper = new ObjectMapper();
            linkDto = mapper.convertValue(link, LinkDTO.class);
        } else {
            throw new NotFoundException("No se encontro el link con ese id");
        }
        return linkDto;
    }

    @Override
    public LinkDTO invalidateLink(String id) {
        Link link = linkRepository.findById(id);
        LinkDTO linkDto;
        if (link != null) {
            linkRepository.delete(link);
            ObjectMapper mapper = new ObjectMapper();
            linkDto = mapper.convertValue(link, LinkDTO.class);
        } else {
            throw new NotFoundException("No se encontro el link con ese id");
        }
        return linkDto;
    }
}
