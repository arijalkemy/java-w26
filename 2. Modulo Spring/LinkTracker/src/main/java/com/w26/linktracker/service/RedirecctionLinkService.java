package com.w26.linktracker.service;

import com.w26.linktracker.entity.Link;
import com.w26.linktracker.exception.RedirectionLinkException;
import com.w26.linktracker.exception.RetriveLinkException;
import com.w26.linktracker.repository.LinkRepository;
import com.w26.linktracker.repository.MetricsRepository;
import org.springframework.stereotype.Service;

@Service
public class RedirecctionLinkService implements IRedirecctionLinkService {

    final LinkRepository linkRepository;
    final MetricsRepository metricsRepository;

    public RedirecctionLinkService(LinkRepository linkRepository, MetricsRepository metricsRepository) {
        this.linkRepository = linkRepository;
        this.metricsRepository = metricsRepository;
    }

    @Override
    public String redirectTo(Integer idLink) {
        Link link = linkRepository.getLink(idLink);
        if (link == null)
            throw new RetriveLinkException("No fue posible recuperar el link con el ID proporcionado", idLink);
        if (!link.isValid())
            throw new RedirectionLinkException("El link al que intentar ser redirigido fue invalidado!!!");

        String urlToRedirect = link.getUrl() + "?password=" + link.getPassword();
        this.metricsRepository.aumentCallsMetricsById(idLink);
        return urlToRedirect;
    }
}
