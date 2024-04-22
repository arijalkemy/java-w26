package com.ejercicio.linktracker.service.interfaces;

import com.ejercicio.linktracker.DTO.LinkDTO;
import com.ejercicio.linktracker.DTO.PostResponseDTO;
import com.ejercicio.linktracker.entity.Link;

public interface ILinkService {
    PostResponseDTO createLink(LinkDTO linkDto);
    String getUrl(int id);
    Link getLink(int id);
    void updateLink(Link link);
    int getRedirects(int id);
}
