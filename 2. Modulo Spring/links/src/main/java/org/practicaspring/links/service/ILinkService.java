package org.practicaspring.links.service;

import org.practicaspring.links.dto.LinkRequestDTO;
import org.practicaspring.links.model.Link;

public interface ILinkService {
    Long createLink(LinkRequestDTO linkDTO, String password);

    Link getLink(Long linkId, String password);
}
