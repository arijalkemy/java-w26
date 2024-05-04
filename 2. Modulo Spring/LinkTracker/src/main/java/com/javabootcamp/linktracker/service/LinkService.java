package com.javabootcamp.linktracker.service;

import com.javabootcamp.linktracker.exception.NotAuthorized;
import com.javabootcamp.linktracker.DTO.CargaLinkDTO;
import com.javabootcamp.linktracker.DTO.MensajeDTO;
import com.javabootcamp.linktracker.model.Link;
import com.javabootcamp.linktracker.repository.LinkRepository;
import com.javabootcamp.linktracker.service.Impl.ILinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LinkService implements ILinkService {
    @Autowired
    LinkRepository linkRepo;

    @Override
    public MensajeDTO cargarLink(CargaLinkDTO nuevoLink) {
        nuevoLink.setId(linkRepo.obtenerTodosLosLinks().size());
        linkRepo.cargarLink(mapDtoToLink(nuevoLink));
        return new MensajeDTO("Link cargado correctamente con id " + nuevoLink.getId());
    }

    @Override
    public MensajeDTO invalidarLink(Integer id, String password) {
        Link link = linkRepo.obtenerPorId(id);

        if(!link.getPassword().equals(password))
        {
            throw new NotAuthorized("No se puede invalidar link, no esta authorizado");
        }
        link.setValido(false);
        linkRepo.editarLink(link);
        return new MensajeDTO("El link con id: "+ id + " ha sido eliminado");
    }

    @Override
    public String redireccionar(Integer id, String password) {
        Link linkrespuesta = linkRepo.obtenerPorId(id);
        if(linkrespuesta==null){
            return "";
        }
        if(!linkrespuesta.getPassword().equals(password)) throw new NotAuthorized("La clave para el link no es valida");
        if(!linkrespuesta.getValido()) throw new NotAuthorized("El link ha sido removido");
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
