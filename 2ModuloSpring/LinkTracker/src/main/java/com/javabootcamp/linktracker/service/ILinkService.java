package com.javabootcamp.linktracker.service;

import com.javabootcamp.linktracker.model.DTO.CargaLinkDTO;
import com.javabootcamp.linktracker.model.DTO.LinkDTO;
import com.javabootcamp.linktracker.model.DTO.MensajeDTO;
import com.javabootcamp.linktracker.model.DTO.RedirectDTO;
import com.javabootcamp.linktracker.model.Link;

public interface ILinkService {
    MensajeDTO cargarLink(CargaLinkDTO nuevoLink);
    MensajeDTO invalidarLink(Integer id, String password);
    String redireccionar(Integer id);
    MensajeDTO obtenerMetricas (Integer id , String password);
}
