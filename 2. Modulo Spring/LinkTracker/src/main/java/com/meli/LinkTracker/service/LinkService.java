package com.meli.LinkTracker.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.LinkTracker.dto.LinkDto;
import com.meli.LinkTracker.dto.LinkIdDto;
import com.meli.LinkTracker.dto.UrlDto;
import com.meli.LinkTracker.model.Link;
import com.meli.LinkTracker.repository.ILinkRepository;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Optional;

@Service
public class LinkService implements ILinkService{

    @Autowired
    private ILinkRepository repository;
    @Override
    public LinkIdDto saveLink(UrlDto urlDto) {
        Link newLink = new Link(urlDto.getUrl());
        repository.save(newLink);
        return new LinkIdDto(newLink.getId());
    }

    @Override
    public void redirect(String linkId, HttpServletResponse response) {
        Optional<Link> link = repository.findById(linkId);

        link.ifPresent(l -> {
            try {
                response.sendRedirect(l.getUrl());
                l.incrementCount();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

    @Override
    public LinkDto getNumberOfRedirects(String linkId) {
        ObjectMapper mapper = new ObjectMapper();
        Optional<Link> link = repository.findById(linkId);

        return mapper.convertValue(link, LinkDto.class);
    }
}
