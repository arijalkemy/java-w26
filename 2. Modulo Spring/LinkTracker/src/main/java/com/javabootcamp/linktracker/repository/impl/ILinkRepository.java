package com.javabootcamp.linktracker.repository.impl;

import com.javabootcamp.linktracker.model.Link;

import java.util.Map;

public interface ILinkRepository {
    Map<Integer, Link> obtenerTodosLosLinks();
    Link obtenerPorId(Integer id);
    void editarLink(Link link);
    void cargarLink(Link link);
}
