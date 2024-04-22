package org.example.linktraker.service.imp;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.linktraker.dto.request.LinkCrearRequestDto;
import org.example.linktraker.dto.response.LinkCrearResponseDto;
import org.example.linktraker.dto.response.LinkMetricasResponseDto;
import org.example.linktraker.entity.LinkPersonalizado;
import org.example.linktraker.exception.link.LinkNotFoundException;
import org.example.linktraker.repository.ILinkRepository;
import org.example.linktraker.service.ILinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LinkServiceImp implements ILinkService {
    @Autowired
    ILinkRepository linkRepository;

    @Autowired
    ObjectMapper objectMapper;

    @Override
    public LinkCrearResponseDto addLink(LinkCrearRequestDto link) {
        return new LinkCrearResponseDto(linkRepository.save(link));
    }

    @Override
    public String redirectLink(int linkId, String password) {
        LinkPersonalizado linkEncontrado = linkRepository.findById(linkId);
        if(linkEncontrado == null){
            throw new LinkNotFoundException("Link no encontrado");
        }
        if(!linkEncontrado.getPassword().equals(password) || !linkEncontrado.isLinkValido()){
            throw new LinkNotFoundException("INVESTIGAR REDIRECT");
        }
        linkEncontrado.setNumeroRedirecciones(
                linkEncontrado.getNumeroRedirecciones() + 1
        );
        return linkEncontrado.getUrl();
    }

    @Override
    public LinkMetricasResponseDto getMetricas(int linkId) {
        LinkPersonalizado link = linkRepository.findById(linkId);
        if(link == null){
            throw new LinkNotFoundException("no existe el link para ese id");
        }
        return objectMapper.convertValue(link, LinkMetricasResponseDto.class);
    }

    @Override
    public void invalidarLink(int linkId, boolean validar) {
        if(!linkRepository.updateLinkValidez(linkId, validar)){
            throw new LinkNotFoundException("No existe un link con ese id");
        }
    }
}
