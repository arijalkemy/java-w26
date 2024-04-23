package com.demospring.linktacker.service;

import com.demospring.linktacker.dto.LinkIdDTO;
import com.demospring.linktacker.dto.LinkRequestDTO;
import com.demospring.linktacker.entity.Link;
import com.demospring.linktacker.exceptions.InvalidPassword;
import com.demospring.linktacker.exceptions.InvalidURL;
import com.demospring.linktacker.exceptions.LinkNotFoundById;
import com.demospring.linktacker.repository.IUryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

@Service
public class UriService implements IUriService {
    @Autowired
    IUryRepository uryRepository;

    @Override
    public LinkIdDTO addLink(LinkRequestDTO LinkRequestDTO, String password) {
        if(!validateLink(LinkRequestDTO.getUri())){
            throw new InvalidURL("URL: " + LinkRequestDTO.getUri() + " invalid.");
        }
        Link link = new Link(LinkRequestDTO.getUri(), password);
        uryRepository.addLink(link);
        return new LinkIdDTO(link.getId(), link.getPassword());
    }

    private boolean validateLink(String uri) {
        final URL url;
        try {
            url = new URL(uri);
        } catch (Exception e1) {
            throw new InvalidURL("URL: " + uri + " invalid.");
        }
        return "https".equals(url.getProtocol());
    }

    @Override
    public String findLinkById(int id, String password) {
        Link link = uryRepository.findLinkById(id, true);
        if(link == null){
            throw new LinkNotFoundById("No link found with id: " + id);
        }else if(!link.getPassword().equals(password)){
            throw new InvalidPassword("Invalid password");
        }
        return link.getUrl();
    }

    @Override
    public int metricsLink(int id) {
        return uryRepository.metricsLink(id);
    }

    @Override
    public void deleteLinkById(int id) {
        uryRepository.deleteLinkById(id);
    }
}
