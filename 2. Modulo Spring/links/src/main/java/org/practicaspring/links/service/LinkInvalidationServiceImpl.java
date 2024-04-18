package org.practicaspring.links.service;

import org.practicaspring.links.exception.LinkNotFoundException;
import org.practicaspring.links.model.Link;
import org.practicaspring.links.repository.ILinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LinkInvalidationServiceImpl implements ILinkInvalidationService{
    @Autowired
    ILinkRepository linkRepository;


    @Override
    public void invalidate(Long id) {
        Link deleted = linkRepository.delete(id);
        if(deleted == null) {
            throw new LinkNotFoundException();
        }
    }
}
