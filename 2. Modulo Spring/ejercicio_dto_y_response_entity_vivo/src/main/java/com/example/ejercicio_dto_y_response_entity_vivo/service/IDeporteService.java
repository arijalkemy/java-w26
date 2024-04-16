package com.example.ejercicio_dto_y_response_entity_vivo.service;

import com.example.ejercicio_dto_y_response_entity_vivo.api.dto.PersonaDeportistaDTO;
import com.example.ejercicio_dto_y_response_entity_vivo.persistence.model.Deporte;

import java.util.List;
import java.util.Optional;

public interface IDeporteService {
    public List<Deporte> getDeportes();
    public Optional<Deporte> consultarDeportePorNombre(String name);
    public List<PersonaDeportistaDTO> obtenerPersonasDeportistas();
}
