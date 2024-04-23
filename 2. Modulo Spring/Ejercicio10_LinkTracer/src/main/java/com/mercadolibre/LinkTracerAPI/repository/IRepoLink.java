package com.mercadolibre.LinkTracerAPI.repository;

import com.mercadolibre.LinkTracerAPI.dto.LinkDTO;
import com.mercadolibre.LinkTracerAPI.entity.Link;

import java.util.List;

public interface IRepoLink {
    public Integer crearLink(Link link);

    public Link redirección (Integer id);

    public Link estadisticaLink (Integer id);

    public boolean validarLink (Integer id);
    public List<Link> obtenerTodos();
}
