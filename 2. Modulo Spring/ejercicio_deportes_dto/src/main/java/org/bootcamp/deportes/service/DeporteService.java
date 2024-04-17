package org.bootcamp.deportes.service;

import org.bootcamp.deportes.domain.Deporte;
import org.bootcamp.deportes.domain.Persona;
import org.bootcamp.deportes.restcontroller.dto.DeporteDTO;
import org.bootcamp.deportes.restcontroller.dto.DeportistasDTO;

import java.util.List;

public interface DeporteService {

    void guardarDeportistas (Deporte deporte, List<Persona> personas);

    List<Deporte> obtenerDeportes();


    DeporteDTO obtenerNivelPorNombreDeporte(String nombre);

    List<DeportistasDTO> obtenerPersonasPorDeporte();

}
