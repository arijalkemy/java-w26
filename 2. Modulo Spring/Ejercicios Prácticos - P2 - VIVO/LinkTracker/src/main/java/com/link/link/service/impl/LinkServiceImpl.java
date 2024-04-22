package com.link.link.service.impl;

import com.link.link.dto.RequestBuscarUrlPorIdDTO;
import com.link.link.dto.RequestCrearUrlDTO;
import com.link.link.dto.ResponseCrearUrlDTO;
import com.link.link.entity.Link;
import com.link.link.exception.UrlNotFoundException;
import com.link.link.repository.ILinkRepository;
import com.link.link.service.ILinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

@Service
public class LinkServiceImpl implements ILinkService {

    @Autowired
    ILinkRepository linkRepository;

    @Override
    public ResponseCrearUrlDTO crearUrl(RequestCrearUrlDTO crearUrlDTO){
        try
        {
            (new URL(crearUrlDTO.getUrl())).openStream().close();
        }
        catch (Exception e)
        {

            throw new RuntimeException(e.getMessage());
        }

        ResponseCrearUrlDTO respuesta = new ResponseCrearUrlDTO();
        Link link = new Link();
        link.setId(linkRepository.getId());
        link.setUrlRediccion(crearUrlDTO.getUrl());

         long idRespuesta = linkRepository.crearLink(link);
         respuesta.setLinkId(idRespuesta);
         return respuesta;
    }

    @Override
    public String buscarUrl(RequestBuscarUrlPorIdDTO requestBuscarUrlPorIdDTO) {
        String respuesta = linkRepository.buscarUrl(requestBuscarUrlPorIdDTO.getIdURL());
        if(respuesta == null)
        {
            throw new UrlNotFoundException("Url no encontrada");
        }
        return respuesta;
    }


}
