package com.example.demo.service.impl;

import com.example.demo.dto.LinkDto;
import com.example.demo.entity.Link;
import com.example.demo.exception.NotFoundException;
import com.example.demo.repository.ILinkTackerRepository;
import com.example.demo.service.ILinkTackerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class LinkTackerServiceImpl implements ILinkTackerService {

    ILinkTackerRepository linkRepository;
    private Long count = 0L;

    @Autowired
    public LinkTackerServiceImpl(ILinkTackerRepository linkRepository) {
        this.linkRepository = linkRepository;
    }

    @Override
    public Long createLink(LinkDto linkDto, String password) {
        Link link = new Link();
        ++count;
        link.setId(count);
        link.setOriginalUrl(linkDto.getOriginalUrl());
        link.setRedirectionCount(0);
        link.setPassword(password);

        // Genera una cadena aleatoria única para enmascarar la URL
        String maskedUrl = UUID.randomUUID().toString().substring(0, 8);
        link.setMaskedUrl(maskedUrl);

        linkRepository.getLinks().add(link);

        return link.getId();
    }

    @Override
    public String getOriginalUrl(Long linkId) {
        if(linkRepository.getLinks().stream().noneMatch(link -> link.getId().equals(linkId))){
            throw new NotFoundException("Not found link");
        }
        Link link = linkRepository.getLinks().stream().filter(link1 -> link1.getId().equals(linkId)).findFirst().get();
        link.setRedirectionCount(link.getRedirectionCount() + 1);

        return link.getOriginalUrl();
    }

    @Override
    public int getRedirectionCount(Long linkId) {
        Optional<Link> optionalLink = linkRepository.getLinks().stream().filter(link -> link.getId().equals(linkId)).findFirst();
        return optionalLink.map(Link::getRedirectionCount).orElse(0);
    }

    @Override
    public boolean invalidateLink(Long linkId, String password) {
        Optional<Link> optionalLink = linkRepository.getLinks().stream().filter(link -> link.getId().equals(linkId)).findFirst();
        if (optionalLink.isPresent()) {
            Link link = optionalLink.get();
            // Verifica que la contraseña coincida
            if (link.getPassword() != null && link.getPassword().equals(password)) {
                // Remueve el enlace de la lista
                linkRepository.getLinks().remove(link);
                return true;
            }
        }
        return false;
    }
}
