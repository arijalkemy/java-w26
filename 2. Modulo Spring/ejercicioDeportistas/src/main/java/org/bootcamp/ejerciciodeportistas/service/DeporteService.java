package org.bootcamp.ejerciciodeportistas.service;

import org.bootcamp.ejerciciodeportistas.dtos.DeporteDTO;

import java.util.List;

public interface DeporteService {
    List<DeporteDTO> obtenerDeportes();
    DeporteDTO obtenerDeportePorNombre(String nombre);
}
