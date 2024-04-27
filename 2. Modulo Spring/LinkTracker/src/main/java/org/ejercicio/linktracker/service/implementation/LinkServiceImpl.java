package org.ejercicio.linktracker.service.implementation;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.ejercicio.linktracker.dto.LinkRequestDto;
import org.ejercicio.linktracker.dto.LinkResponseDto;
import org.ejercicio.linktracker.dto.MetricsRedirectionDto;
import org.ejercicio.linktracker.entity.Link;
import org.ejercicio.linktracker.exception.BadRequestException;
import org.ejercicio.linktracker.repository.ILinkRepository;
import org.ejercicio.linktracker.service.ILinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.UUID;

@Service
public class LinkServiceImpl implements ILinkService {

    private ILinkRepository linkRepository;
    private ObjectMapper objectMapper;

    public LinkServiceImpl(@Autowired ILinkRepository linkRepository) {
        this.linkRepository = linkRepository;
        this.objectMapper = new ObjectMapper();
    }

    @Override
    public LinkResponseDto createLink(LinkRequestDto linkRequestDto) {
        if (linkRequestDto.getLink() == null || linkRequestDto.getLink().isBlank()
                || linkRequestDto.getPassword() == null || linkRequestDto.getPassword().isBlank()){
            throw new BadRequestException("Datos no informados en la solicitud");
        }
        validateLink(linkRequestDto.getLink());
        Link link = linkRepository.save(new Link(linkRequestDto.getLink(), linkRequestDto.getPassword()));
        return objectMapper.convertValue(link, LinkResponseDto.class);
    }

    @Override
    public Boolean validateLink(String url) {
        try{
            new URL(url).toURI();
            return true;
        } catch (MalformedURLException | URISyntaxException e) {
            throw new BadRequestException("URL invalida");
        }
    }

    @Override
    public HttpHeaders redirectLinkAction(UUID linkId, String password) {
        Link link = linkRepository.findById(linkId);
        if (link == null || !link.getPassword().equals(password))
            throw new BadRequestException("Link no encontrado o contraseña invalida");
        HttpHeaders headers = new HttpHeaders();
        try {
            headers.setLocation(new URL(link.getLink()).toURI());
            linkRepository.updateCountRedirectionsLinkById(linkId);
        }catch (MalformedURLException | URISyntaxException e) {
            throw new BadRequestException("Error en la url del link");
        }
        return headers;
    }

    @Override
    public MetricsRedirectionDto getMetricsById(UUID linkId) {
        Link link = linkRepository.findById(linkId);
        if (link == null) throw new BadRequestException("Link no existente");
        return new MetricsRedirectionDto(link.getLink(), link.getRedirections());
    }

    @Override
    public void invalidateLink(UUID linkId) {
        Link link = linkRepository.findById(linkId);
        if (link == null) throw new BadRequestException("Link no existente");
        linkRepository.deleteLink(linkId);
    }
}
