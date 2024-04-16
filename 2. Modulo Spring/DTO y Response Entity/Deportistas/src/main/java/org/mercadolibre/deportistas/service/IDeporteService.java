package org.mercadolibre.deportistas.service;

import org.mercadolibre.deportistas.model.Deporte;
import org.mercadolibre.deportistas.model.DeportistaDTO;

import java.util.List;

public interface IDeporteService {
    public List<Deporte> getDeportes();
    public String getNivelDeDeporte(String nombreDeporte);
    public List<DeportistaDTO> getDeportistas();
}
