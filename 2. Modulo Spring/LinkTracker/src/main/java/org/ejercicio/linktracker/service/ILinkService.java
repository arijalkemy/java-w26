package org.ejercicio.linktracker.service;

import org.ejercicio.linktracker.dto.LinkRequestDto;
import org.ejercicio.linktracker.dto.LinkResponseDto;
import org.springframework.http.HttpHeaders;

import java.util.UUID;

public interface ILinkService {
    LinkResponseDto createLink(LinkRequestDto linkRequestDto);
    Boolean validateLink(String url);
    HttpHeaders redirectLinkAction(UUID linkId, String password);
}
