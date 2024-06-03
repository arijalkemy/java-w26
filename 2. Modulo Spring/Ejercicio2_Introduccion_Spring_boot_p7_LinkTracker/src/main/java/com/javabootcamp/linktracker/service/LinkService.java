package com.javabootcamp.linktracker.service;

import com.javabootcamp.linktracker.model.DTO.CargaLinkDTO;
import com.javabootcamp.linktracker.model.DTO.LinkDTO;
import com.javabootcamp.linktracker.model.DTO.MensajeDTO;
import com.javabootcamp.linktracker.model.DTO.RedirectDTO;
import com.javabootcamp.linktracker.model.Link;
import com.javabootcamp.linktracker.repository.LinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LinkService implements  ILinkService{
    @Autowired
    LinkRepository linkRepo;

    @Override
    public MensajeDTO cargarLink(CargaLinkDTO nuevoLink) {
        linkRepo.cargarLink(mapDtoToLink(nuevoLink));
        return new MensajeDTO("Link cargado correctamente con id " + nuevoLink.getId());
    }

    @Override
    public MensajeDTO invalidarLink(Integer id, String password) {
        return null;
    }

    @Override
    public String redireccionar(Integer id) {
        Link linkrespuesta = linkRepo.obtenerPorId(id);
        if(linkrespuesta==null){
            return "";
        }
        linkRepo.subirUnaVistaPorId(id);
        return linkrespuesta.getUrl();
    }

    @Override
    public MensajeDTO obtenerMetricas(Integer id) {
        return new MensajeDTO("El numero de visistas del link es " + linkRepo.obtenerPorId(id).getVistas());
    }

    private Link mapDtoToLink(CargaLinkDTO dto){
        return new Link(dto.getId(), dto.getUrl(),0,dto.getPassword(),false);
    }

}
