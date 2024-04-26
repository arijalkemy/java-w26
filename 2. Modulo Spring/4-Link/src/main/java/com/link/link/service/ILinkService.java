package com.link.link.service;

import com.link.link.dto.RequestBuscarUrlPorIdDTO;
import com.link.link.dto.RequestCrearUrlDTO;
import com.link.link.dto.ResponseCrearUrlDTO;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

public interface ILinkService {
    public ResponseCrearUrlDTO crearUrl(RequestCrearUrlDTO crearUrlDTO) throws MalformedURLException, URISyntaxException;
    public String buscarUrl(RequestBuscarUrlPorIdDTO requestBuscarUrlPorIdDTO);
}
