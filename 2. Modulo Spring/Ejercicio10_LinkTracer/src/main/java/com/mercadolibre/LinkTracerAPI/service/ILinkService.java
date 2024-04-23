package com.mercadolibre.LinkTracerAPI.service;

import com.mercadolibre.LinkTracerAPI.dto.LinkDTO;
import com.mercadolibre.LinkTracerAPI.dto.LinkEstadisticaDTO;
import com.mercadolibre.LinkTracerAPI.dto.LinkRedireccionDTO;
import com.mercadolibre.LinkTracerAPI.entity.Link;

import java.util.List;

public interface ILinkService {
    public Integer crearLink(LinkDTO link);

    public LinkRedireccionDTO redirección (Integer id);

    public LinkEstadisticaDTO estadisticaLink (Integer id);

    public boolean validarLink (Integer id);

    public List<LinkDTO> obtenerTodos();
}
