package org.bootcamp.linktracker.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.bootcamp.linktracker.dto.LinkDTO;
import org.bootcamp.linktracker.model.Link;
import org.bootcamp.linktracker.repository.ILinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LinkServiceImpl implements ILinkService{
    @Autowired private ILinkRepository linkRepository;

    @Override
    public LinkDTO create(LinkDTO link) {
        ObjectMapper objectMapper = new ObjectMapper();
        Link linkObj = objectMapper.convertValue(link, Link.class);

    }

    @Override
    public LinkDTO redirect(Integer linkId) {
        return null;
    }

    @Override
    public LinkDTO redirect(Integer linkId, String password) {
        return null;
    }

    @Override
    public LinkDTO metrics(Integer linkId) {
        return null;
    }
}
