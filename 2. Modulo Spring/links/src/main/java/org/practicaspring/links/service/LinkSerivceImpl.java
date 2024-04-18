package org.practicaspring.links.service;

import org.practicaspring.links.dto.LinkRequestDTO;
import org.practicaspring.links.exception.LinkNotFoundException;
import org.practicaspring.links.model.Link;
import org.practicaspring.links.repository.ILinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LinkSerivceImpl implements ILinkService{
    @Autowired
    private ILinkRepository linkRepository;

    @Override
    public Long createLink(LinkRequestDTO linkDTO, String password) {
        Link link = new Link(linkDTO.getUrl(), password);
        linkRepository.add(link);
        return link.getId();
    }

    @Override
    public Link getLink(Long linkId, String password) {
        Link link = linkRepository.findLink(linkId, password);
        if(link == null){
            throw new LinkNotFoundException("Link: " + linkId + ((password != null) ? " with password: " + password : "") + " not found");
        }
        return link;
    }
}
