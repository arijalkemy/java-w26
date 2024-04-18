package org.practicaspring.links.service;

import org.practicaspring.links.exception.LinkNotFoundException;
import org.practicaspring.links.repository.ILinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LinkMetricsServiceImpl implements ILinkMetricsService {
    @Autowired
    ILinkRepository linkRepository;

    @Override
    public Integer checkMetrics(Long linkId) {
        Integer accesses = linkRepository.getMetricsById(linkId);
        if(accesses == null) {
            throw new LinkNotFoundException();
        }
        return accesses;
    }
}
