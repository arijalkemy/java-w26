package org.example.linktracker.service;

import org.example.linktracker.dto.CreateLinkResponseDTO;
import org.example.linktracker.dto.LinkDTO;
import org.example.linktracker.exception.LinkNotFoundException;
import org.example.linktracker.model.Link;
import org.example.linktracker.repository.LinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LinkService {

    @Autowired
    private LinkRepository linkRepository;

    public CreateLinkResponseDTO createLink(String url, String password) {
        Link link = new Link(null, url, password, true, 0);
        Link savedLink = linkRepository.save(link);
        return new CreateLinkResponseDTO(savedLink.getId());
    }

    public String getRedirectUrl(Integer id, Optional<String> password) {
        Link link = linkRepository.findById(id);
        if (link == null || !link.isValid() || (link.getPassword() != null && !link.getPassword().equals(password.orElse(null)))) {
            throw new LinkNotFoundException("Link not found or invalid");
        }
        linkRepository.incrementRedirectCount(id);
        return link.getUrl();
    }

    public LinkDTO getLinkMetrics(Integer id) {
        Link link = linkRepository.findById(id);
        if (link == null) {
            throw new LinkNotFoundException("Link not found");
        }
        return new LinkDTO(link.getId(), link.getUrl(), link.getPassword(), link.isValid(), link.getRedirectCount());
    }

    public void invalidateLink(Integer id) {
        if (!linkRepository.existsById(id)) {
            throw new LinkNotFoundException("Link not found");
        }
        linkRepository.invalidate(id);
    }
}
