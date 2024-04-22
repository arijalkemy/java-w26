package com.ejercicio.linktracker.repository.interfaces;

import com.ejercicio.linktracker.entity.Link;

public interface ILinkRepository {
    Link add(Link link);
    Link get(int linkId);
    void update(Link link);
}
