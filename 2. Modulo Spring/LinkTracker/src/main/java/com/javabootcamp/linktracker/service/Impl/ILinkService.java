package com.javabootcamp.linktracker.service.Impl;

import com.javabootcamp.linktracker.DTO.CargaLinkDTO;
import com.javabootcamp.linktracker.DTO.MensajeDTO;

public interface ILinkService {
    MensajeDTO cargarLink(CargaLinkDTO nuevoLink);
    MensajeDTO invalidarLink(Integer id, String password);
    String redireccionar(Integer id,String password);
    MensajeDTO obtenerMetricas (Integer id );
}
