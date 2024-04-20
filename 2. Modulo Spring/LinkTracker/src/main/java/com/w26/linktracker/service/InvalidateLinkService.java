package com.w26.linktracker.service;

import com.w26.linktracker.dto.InvalidationLinkResult;
import com.w26.linktracker.entity.Link;
import com.w26.linktracker.exception.RetriveLinkException;
import com.w26.linktracker.repository.LinkRepository;
import org.springframework.stereotype.Service;

@Service
public class InvalidateLinkService implements IInvalidateLinkService {

    final LinkRepository linkRepository;

    public InvalidateLinkService(LinkRepository linkRepository) {
        this.linkRepository = linkRepository;
    }

    @Override
    public InvalidationLinkResult invalidateLinkById(Integer linkId) {
        Link linkToInvalidate = linkRepository.getLink(linkId);
        if(linkToInvalidate == null)
            throw new RetriveLinkException("No fue posible recuperar el link para invalidarlo, verifique su ID", linkId);
        linkToInvalidate.setValid(false);

        InvalidationLinkResult result = new InvalidationLinkResult(linkId, "El link con el ID proporcioando fue invalidado.");

        return result;
    }
}
