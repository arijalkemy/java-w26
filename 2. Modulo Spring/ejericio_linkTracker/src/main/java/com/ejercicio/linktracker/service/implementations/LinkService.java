package com.ejercicio.linktracker.service.implementations;

import com.ejercicio.linktracker.DTO.LinkDTO;
import com.ejercicio.linktracker.DTO.PostResponseDTO;
import com.ejercicio.linktracker.entity.Link;
import com.ejercicio.linktracker.exception.AlreadyExistException;
import com.ejercicio.linktracker.exception.NotFoundException;
import com.ejercicio.linktracker.repository.interfaces.ILinkRepository;
import com.ejercicio.linktracker.service.interfaces.ILinkService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.MalformedURLException;
import java.net.URL;

@Service
public class LinkService implements ILinkService {

    @Autowired
    private ILinkRepository linkRepository;
    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public PostResponseDTO createLink(LinkDTO linkDto) {
        Link link = objectMapper.convertValue(linkDto, Link.class);
        Link result = linkRepository.get(linkDto.getId());
        if (result != null) throw new AlreadyExistException(
                "Ya existe un Link con Id: " + linkDto.getId()
        );

        linkRepository.add(link);
        return new PostResponseDTO(
                linkDto.getId()
        );
    }

    @Override
    public String getUrl(int id) {
        Link result = getLink(id);

        try{
            URL url = new URL(result.getUrl());
        } catch (MalformedURLException e) {
            throw new NotFoundException(
                    "Link inválido."
            );
        }

        result.setVisitsNumber(result.getVisitsNumber() + 1);
        updateLink(result);
        return result.getUrl();
    }

    @Override
    public Link getLink(int id) {
        Link result = linkRepository.get(id);
        if(result == null) throw new NotFoundException(
                "No existe un Link con Id: " + id
        );

        return result;
    }

    @Override
    public void updateLink(Link link) {
        linkRepository.update(link);
    }

    @Override
    public int getRedirects(int id) {
        return getLink(id).getVisitsNumber();
    }
}
