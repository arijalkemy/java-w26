package com.example.link.servicios.impl;

import com.example.link.DTOs.LinkRequestDTO;
import com.example.link.DTOs.LinkResponseDTO;
import com.example.link.DTOs.MetricResponseDTO;
import com.example.link.exceptions.InvalidURLException;
import com.example.link.modelo.Link;
import com.example.link.repositorios.interfaces.ILinkRepositorio;
import com.example.link.servicios.interfaces.ILinkServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;


@Service
public class LinkServicioImpl implements ILinkServicio {

    private final ILinkRepositorio linkRepositorio;

    public LinkServicioImpl(ILinkRepositorio linkRepositorio) {
        this.linkRepositorio = linkRepositorio;
    }


    @Override
    public LinkResponseDTO crearLink(LinkRequestDTO linkRequestDTO) {

        Link link = new Link((int) (Math.random() * 100), linkRequestDTO.getUrl());

        linkRepositorio.guardarLink(link);

        return new LinkResponseDTO(link.getId());
    }

    @Override
    public Link buscarLink(int id) {
        Link link = this.linkRepositorio.buscarPorId(id).get();

        return link;
    }

    @Override
    public ResponseEntity<?> redirect(int id) {

        Link link = this.buscarLink(id);


        if(link.isEstaInvalidado()){
            throw new InvalidURLException("URL invalidada");
        } else {
            link.redireccionar();
        }


        try{
            URL url = new URL(link.getUrl()).toURI().toURL();

            HttpHeaders headers = new HttpHeaders();
            headers.setLocation(url.toURI());
            return new ResponseEntity<>(headers, HttpStatus.SEE_OTHER);

        } catch (MalformedURLException | URISyntaxException e){
            throw new InvalidURLException("URL invalida");
        }
    }

    @Override
    public MetricResponseDTO getMetricsFrom(int id) {

        Link link  = this.buscarLink(id);

        return new MetricResponseDTO(link.getId(),link.getCantidadDeVecesQueSeRedirecciono());
    }

    @Override
    public LinkResponseDTO invalidateLinkFromId(int id) {
        Link link  = this.buscarLink(id);

        link.invalidar();

        this.linkRepositorio.guardar(link);
        return new LinkResponseDTO(link.getId());
    }

}
