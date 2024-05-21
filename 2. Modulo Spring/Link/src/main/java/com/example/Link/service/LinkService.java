package com.example.Link.service;

import com.example.Link.entity.Link;
import com.example.Link.dto.LinkDTO;
import com.example.Link.repository.LinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LinkService implements ILinkService {
    private final LinkRepository linkRepository;

    @Autowired
    public LinkService(LinkRepository linkRepository) {
        this.linkRepository = linkRepository;
    }

    @Override
    public LinkDTO createLink(String url) {
        // Assuming Link has a constructor that matches this usage
        Link link = new Link(null, url, true);
        link = linkRepository.save(link);
        return new LinkDTO(link.getId(), link.getUrl(), link.isValid());
    }

    @Override
    public LinkDTO getLinkById(Integer id) {
        Link link = linkRepository.findById(id).orElse(null);
        if (link != null && link.isValid()) {
            return new LinkDTO(link.getId(), link.getUrl(), link.isValid());
        }
        return null;
    }

    @Override
    public LinkDTO getLinkDTO(Integer id) {
        // Implementation for the missing method, similar to getLinkById
        return getLinkById(id);
    }

    @Override
    public String redirect(Integer id) {
        Link link = linkRepository.findById(id).orElse(null);
        if (link != null && link.isValid()) {
            link.setAccessCount(link.getAccessCount() + 1);
            linkRepository.save(link);  // Update link access count in the repository
            return link.getUrl();
        }
        return null;
    }

    @Override
    public void invalidateLink(Integer id) {
        linkRepository.invalidate(id);
    }
}

