package com.link.link.repository;

import com.link.link.entity.Link;

public interface ILinkRepository {
    public Long crearLink(Link url);
    public Long getId();

    public String buscarUrl(Long id);
}
