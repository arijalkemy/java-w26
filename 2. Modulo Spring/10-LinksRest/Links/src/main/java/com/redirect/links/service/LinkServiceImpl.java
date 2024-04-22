package com.redirect.links.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.redirect.links.dto.request.LinkRequestDTO;
import com.redirect.links.dto.response.LinkResponseDTO;
import com.redirect.links.entities.Link;
import com.redirect.links.exceptions.BadRequestException;
import com.redirect.links.repositories.ILinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class LinkServiceImpl implements ILinkService{

    @Autowired
    ILinkRepository linkRepository;



    @Override
    public LinkResponseDTO addURL(LinkRequestDTO link) {
        ObjectMapper mapper = new ObjectMapper();
        Link linkToAdd = mapper.convertValue(link, Link.class);

        Integer id = linkRepository.addLink(linkToAdd);

        LinkResponseDTO linkResponse = new LinkResponseDTO(id);

        return linkResponse;
    }

    @Override
    public String redirectURL(Integer id, String password) {
        Link linkToRedirect = linkRepository.showLink(id, password);
        if (!linkToRedirect.isValid()){
            throw new BadRequestException("El link solicitado fue declarado invalido.");
        }
        return linkToRedirect.getUrl();
    }

    @Override
    public Integer metricsURL(Integer id) {
        Link link = linkRepository.giveLinkNoPassword(id);
        return link.getCounter();
    }

    @Override
    public String invalidateURL(Integer id) {
        linkRepository.invalidateLink(id);
        String message = "Se invalidó el link con el id: " + id;
        return message;
    }
}
