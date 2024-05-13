package org.example.link_tracer.service.Impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.link_tracer.dto.LinkRequestDTO;
import org.example.link_tracer.dto.LinkResponseDTO;
import org.example.link_tracer.dto.MetricsLinkResponseDTO;
import org.example.link_tracer.exception.BadUrlException;
import org.example.link_tracer.exception.DisabledUrlException;
import org.example.link_tracer.exception.NotFoundException;
import org.example.link_tracer.exception.WrongPasswordException;
import org.example.link_tracer.model.Link;
import org.example.link_tracer.repository.ILinkRepository;
import org.example.link_tracer.service.ILinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Optional;

@Service
public class LinkServiceImpl implements ILinkService {

    @Autowired
    ILinkRepository linkRepository;

    ObjectMapper objectMapper=new ObjectMapper();

    @Override
    public LinkResponseDTO newLink(LinkRequestDTO link) {
        Link savedLink = linkRepository.save(convert(link));
        return convert(savedLink);
    }

    @Override
    public LinkResponseDTO disbleLink(Integer id) {
        Link link = disableOrEnableLink(id,false);
        return convert(link);
    }

    @Override
    public LinkResponseDTO enableLink(Integer id) {
        Link link = disableOrEnableLink(id,true);
        return convert(link);
    }

    @Override
    public MetricsLinkResponseDTO metricsLink(Integer id) {
        Link link= getLinkById(id);
        return convertToMetrics(link);
    }

    @Override
    public URI redirect(Integer id) throws MalformedURLException, URISyntaxException{
        Link link = getLinkById(id);
        if(!isValidLink(link))
            throw new DisabledUrlException("El link está deshabilitado");
        if(!isValidLink(link.getLink()))
            throw new BadUrlException("La url no es válida");
        link.setUsages(link.getUsages()+1);
        linkRepository.save(link);
        return new URI(link.getLink());
    }

    @Override
    public URI redirect(Integer id, String password) throws MalformedURLException, URISyntaxException {

        Link link = getLinkById(id);
        if(!isValidLink(link))
            throw new DisabledUrlException("El link está deshabilitado");
        if(hasPassword(link) && !link.getPassword().equals(password))
                throw new WrongPasswordException("La clave no es correcta");
        if(!isValidLink(link.getLink()))
            throw new BadUrlException("La url no es válida");
        link.setUsages(link.getUsages()+1);
        linkRepository.save(link);
        return new URI(link.getLink());
    }

    private Link getLinkById(Integer id){
        Optional<Link> optionalLink = linkRepository.findById(id);
        if (!optionalLink.isPresent())
            throw new NotFoundException("El link con id:"+id+"no existe");
        return optionalLink.get();
    }

    private Link disableOrEnableLink(Integer id,Boolean enabled){
        Link link = getLinkById(id);
        link.setEnabled(enabled);
        linkRepository.save(link);
        return link;
    }

    private Boolean isValidLink(String urlLink) throws MalformedURLException, URISyntaxException {
        try {
            new URL(urlLink).toURI();
            return true;
        } catch (MalformedURLException | URISyntaxException e) {
            return false;
        }
    }
    private Boolean hasPassword(Link link){
        return link.getPassword()!=null;
    }

    private MetricsLinkResponseDTO convertToMetrics(Link link){
        return objectMapper.convertValue(link,MetricsLinkResponseDTO.class);
    }
    private Link convert(LinkRequestDTO link){
        return objectMapper.convertValue(link,Link.class);
    }

    private LinkResponseDTO convert(Link link){
        return objectMapper.convertValue(link,LinkResponseDTO.class);
    }

    private Boolean isValidLink(Link link){
        return link.getEnabled();
    }
}
