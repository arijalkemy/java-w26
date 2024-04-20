package org.responseentity.linktracker.service;

import org.apache.coyote.BadRequestException;
import org.responseentity.linktracker.dto.LinkDTO;
import org.responseentity.linktracker.dto.LinkInvalidateDTO;
import org.responseentity.linktracker.dto.LinkMetricDTO;
import org.responseentity.linktracker.entity.LinkEntity;
import org.responseentity.linktracker.exceptions.RequestException;
import org.responseentity.linktracker.mapper.LinkMapper;
import org.responseentity.linktracker.repository.LinkResposity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class LinkServiceImp implements LinkService{
    private final String homePath = "http://localhost:8080/api/";
    private final String adminPass = "12ciervosvivos";

    @Autowired
    LinkResposity linkResposity;

    @Override
    public LinkDTO insertLink(String subPath) {
        LinkEntity linkEntity = new LinkEntity(UUID.randomUUID(), homePath+subPath, 0, true);
        linkResposity.insertLink(linkEntity);
        return LinkMapper.entityToDTO(linkEntity);
    }

    @Override
    public List<LinkDTO> getAllTheLinks() {
        return linkResposity.getAllTheLink()
                .stream()
                .map(x -> LinkMapper.entityToDTO(x))
                .toList();
    }

    @Override
    public LinkDTO getLinkById(UUID id) {
        Optional<LinkEntity> linkMasked = linkResposity.getLinkById(id);
        if(!linkMasked.isPresent()){
            throw new NullPointerException("No se localizo el link");
        }

        linkMasked.get().setNumberOfRedirects(linkMasked.get().getNumberOfRedirects()+1);
        return LinkMapper.entityToDTO(linkMasked.get());
    }

    @Override
    public LinkMetricDTO getMetricsOfVideoById(UUID id){
        Optional<LinkEntity> linkMasked = linkResposity.getLinkById(id);
        if(!linkMasked.isPresent()){
            throw new NullPointerException("No se localizo el link");
        }

        return LinkMapper.entityToMetricDTO(linkMasked.get());
    }

    @Override
    public LinkInvalidateDTO invalidatesLinkById(UUID id, String pass) {
        // check the pass
        if(!pass.equals(adminPass)){
            throw new RequestException("La contrasena no es correcta");
        }

        // check if the links still is active
        Optional<LinkEntity> isActiveLink = linkResposity.getLinkById(id);
        if(!isActiveLink.isPresent()){
            throw new NullPointerException("No se localizo el link a invalidar");
        }

        // invalidates the link
        linkResposity.invalidateLink(id);
        LinkInvalidateDTO linkInvalidateDTO = LinkInvalidateDTO.builder()
                .id(id)
                .source(isActiveLink.get().getSource())
                .message("Se ha desactivado el link")
                .build();


        return linkInvalidateDTO;
    }

}
