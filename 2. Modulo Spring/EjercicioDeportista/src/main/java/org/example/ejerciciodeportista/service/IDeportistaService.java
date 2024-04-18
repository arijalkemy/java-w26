package org.example.ejerciciodeportista.service;

import org.example.ejerciciodeportista.dto.DeporteDTO;
import org.example.ejerciciodeportista.dto.DeportistaDTO;

import java.util.List;

public interface IDeportistaService {
    public List<DeporteDTO> findAllDeportes();
    public List<DeporteDTO> findDeportesByName(String name);
    public List<DeportistaDTO> findDeportistas();
}
