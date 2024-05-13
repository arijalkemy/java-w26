package org.example.link_tracer.service;

import org.example.link_tracer.dto.LinkRequestDTO;
import org.example.link_tracer.dto.LinkResponseDTO;
import org.example.link_tracer.dto.MetricsLinkResponseDTO;
import org.springframework.http.ResponseEntity;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

public interface ILinkService {
    public LinkResponseDTO newLink(LinkRequestDTO link);
    public MetricsLinkResponseDTO metricsLink (Integer id);
    public URI redirect(Integer id) throws MalformedURLException, URISyntaxException;
    public URI redirect(Integer id, String password) throws MalformedURLException, URISyntaxException;
    public LinkResponseDTO disbleLink(Integer id);
    public LinkResponseDTO enableLink(Integer id);
}
