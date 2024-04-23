package com.demospring.linktacker.service;

import com.demospring.linktacker.dto.LinkIdDTO;
import com.demospring.linktacker.dto.LinkRequestDTO;
import com.demospring.linktacker.entity.Link;
import org.springframework.http.ResponseEntity;

import java.net.URISyntaxException;

public interface IUriService {
    LinkIdDTO addLink(LinkRequestDTO linkRequestDTO, String password);
    String findLinkById(int id, String password);
    int metricsLink(int id);
    void deleteLinkById(int id);
}
