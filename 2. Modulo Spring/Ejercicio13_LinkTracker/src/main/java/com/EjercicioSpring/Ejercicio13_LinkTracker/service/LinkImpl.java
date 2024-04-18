package com.EjercicioSpring.Ejercicio13_LinkTracker.service;

import com.EjercicioSpring.Ejercicio13_LinkTracker.dto.LinkIdResponseDTO;
import com.EjercicioSpring.Ejercicio13_LinkTracker.dto.LinkRequestDTO;
import com.EjercicioSpring.Ejercicio13_LinkTracker.dto.LinkResponseDTO;
import com.EjercicioSpring.Ejercicio13_LinkTracker.entity.Link;
import com.EjercicioSpring.Ejercicio13_LinkTracker.exception.LinkException;
import com.EjercicioSpring.Ejercicio13_LinkTracker.repository.ILinkRepository;
import com.EjercicioSpring.Ejercicio13_LinkTracker.service.interfaces.ILinkService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class LinkImpl implements ILinkService {

    @Autowired
    ILinkRepository linkRepository;

    ObjectMapper objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());

    @Override
    public LinkIdResponseDTO createLink(LinkRequestDTO linkRequestDTO) {
        int linkID = linkRepository.getSize() + 1;
        Link link = new Link(linkID, linkRequestDTO.getUrl(), linkRequestDTO.getPassword());
        if (linkRepository.addLink(link)) {
            return objectMapper.convertValue(link, LinkIdResponseDTO.class);
        }
        throw new LinkException("Ya se encuentra registrado dicho link", HttpStatus.CONFLICT);
    }

    @Override
    public String redirect(Integer linkId, String password) {
        Link link = linkRepository.getLinkById(linkId);
        if (link == null) {
            throw new LinkException("No existe un link con el ID " + linkId, HttpStatus.NOT_FOUND);
        }
        if (!link.getPassword().equals(password)) {
            throw new LinkException("La contraseña no es validia", HttpStatus.BAD_REQUEST);
        }
        if (!link.isValid()) {
            throw new LinkException("El acceso a este link no es valido", HttpStatus.FORBIDDEN);
        }
        linkRepository.updateCount(linkId);
        return link.getOriginalUrl();
    }

    @Override
    public LinkResponseDTO getMetrics(Integer linkId) {
        Link link = linkRepository.getLinkById(linkId);
        if (link == null) {
            throw new LinkException("No existe un link con el ID " + link, HttpStatus.NOT_FOUND);
        }
        return objectMapper.convertValue(link, LinkResponseDTO.class);
    }

    @Override
    public boolean invalidateLink(Integer linkId) {
        Link link = linkRepository.getLinkById(linkId);
        if (link == null) {
            throw new LinkException("No existe un link con el ID " + link, HttpStatus.NOT_FOUND);
        }
        linkRepository.updateValidationLink(link);
        return true;
    }
}
