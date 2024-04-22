package com.example.link.servicios.interfaces;

import com.example.link.DTOs.LinkRequestDTO;
import com.example.link.DTOs.LinkResponseDTO;
import com.example.link.DTOs.MetricResponseDTO;
import com.example.link.modelo.Link;
import org.springframework.http.ResponseEntity;

public interface ILinkServicio {

    public LinkResponseDTO crearLink(LinkRequestDTO linkRequestDTO);

    public Link buscarLink(int id);

    public ResponseEntity<?> redirect(int id);

    public MetricResponseDTO getMetricsFrom(int id);

    public LinkResponseDTO invalidateLinkFromId(int id);

}
