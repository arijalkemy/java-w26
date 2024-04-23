package com.mercadolibre.LinkTracerAPI.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.LinkTracerAPI.dto.LinkDTO;
import com.mercadolibre.LinkTracerAPI.dto.LinkEstadisticaDTO;
import com.mercadolibre.LinkTracerAPI.dto.LinkRedireccionDTO;
import com.mercadolibre.LinkTracerAPI.entity.Link;
import com.mercadolibre.LinkTracerAPI.exception.BadRequestException;
import com.mercadolibre.LinkTracerAPI.exception.NotFoundException;
import com.mercadolibre.LinkTracerAPI.repository.IRepoLink;
import com.mercadolibre.LinkTracerAPI.service.ILinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LinkServiceImpl implements ILinkService {

    @Autowired
    IRepoLink repoLink;

    @Override
    public Integer crearLink(LinkDTO link) {
        ObjectMapper mapper = new ObjectMapper();
        Integer idLink = repoLink.crearLink(mapper.convertValue(link,Link.class));
        if (idLink != null){
            return idLink;
        }else {
            throw new BadRequestException("El link ya existe o verifica la información");
        }
    }

    @Override
    public LinkRedireccionDTO redirección(Integer id) {
        Link link = repoLink.redirección(id);
        if (link != null){
            ObjectMapper mapper = new ObjectMapper();
            return mapper.convertValue(link,LinkRedireccionDTO.class);
        }else {
            throw new NotFoundException("Investigar Redirect");
        }
    }

    @Override
    public List<LinkDTO> obtenerTodos() {
        List<LinkDTO> linkDTOS = new ArrayList<>();
        List<Link> links = repoLink.obtenerTodos();
        for (Link link: links){
            ObjectMapper mapper = new ObjectMapper();
            linkDTOS.add(mapper.convertValue(link,LinkDTO.class));
        }
        return linkDTOS;
    }

    @Override
    public LinkEstadisticaDTO estadisticaLink(Integer id) {
        Link link = repoLink.estadisticaLink(id);
        if (link != null){
            ObjectMapper mapper = new ObjectMapper();
            return mapper.convertValue(link,LinkEstadisticaDTO.class);
        }else {
            throw new NotFoundException("No se encontro el link solicitado");
        }
    }

    @Override
    public boolean validarLink(Integer id) {
        if (repoLink.validarLink(id)){
            return true;
        }else {
            throw new BadRequestException("No existe el link verifique la información");
        }
    }
}
