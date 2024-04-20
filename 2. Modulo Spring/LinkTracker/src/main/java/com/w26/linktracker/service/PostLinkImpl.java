package com.w26.linktracker.service;

import com.w26.linktracker.dto.LinkCreation;
import com.w26.linktracker.dto.LinkResultCreation;
import com.w26.linktracker.entity.Link;
import com.w26.linktracker.exception.CreationLinkException;
import com.w26.linktracker.repository.LinkRepository;
import com.w26.linktracker.repository.MetricsRepository;
import org.springframework.stereotype.Service;

@Service
public class PostLinkImpl implements IPostLink {

    final LinkRepository linkRepository;
    final MetricsRepository metricsRepository;

    public PostLinkImpl(LinkRepository linkRepository, MetricsRepository metricsRepository)
    {
        this.linkRepository = linkRepository;
        this.metricsRepository = metricsRepository;
    }

    @Override
    public LinkResultCreation createLink(LinkCreation linkCreation, String password)
    {
        if (!linkCreation.getUrl().contains("http://") && !linkCreation.getUrl().contains("https://"))
        {
            throw new CreationLinkException("La url a enmascarar no es valido!!!");
        }


        Link linkNew = new Link(Link.generateId(), password, linkCreation.getUrl(), true);

        linkRepository.addLink(linkNew.getId(),linkNew);
        metricsRepository.addTraceToLink(linkNew.getId());
        LinkResultCreation response = new LinkResultCreation("Link creado correctamente.", linkNew.getId());
        return response;
    }

}
