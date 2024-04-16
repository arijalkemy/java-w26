package com.example.ejercicio_dto_y_response_entity_p2.service.implementation;

import com.example.ejercicio_dto_y_response_entity_p2.dto.PersonaRiesgoDTO;
import com.example.ejercicio_dto_y_response_entity_p2.persistence.entity.Sintoma;

import java.util.List;

public interface ISintomaService {
    public List<Sintoma> obtenerSintomas();
    public String obtenerGravedadSintoma(String name);
    public List<PersonaRiesgoDTO> obtenerPersonasRiesgo();
}
