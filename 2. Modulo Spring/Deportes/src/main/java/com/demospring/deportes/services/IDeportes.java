package com.demospring.deportes.services;

import com.demospring.deportes.entities.Deporte;
import com.demospring.deportes.dtos.PersonaDeporteDTO;

import java.util.List;

public interface IDeportes {
    List<Deporte> getDeportes();
    Deporte getDeporte(String nombre);
    List<PersonaDeporteDTO> getDeportesPersonas();
}
