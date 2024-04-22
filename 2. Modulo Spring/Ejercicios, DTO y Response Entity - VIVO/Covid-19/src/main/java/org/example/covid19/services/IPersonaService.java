package org.example.covid19.services;

import org.example.covid19.dto.PersonaDTO;

import java.util.List;

public interface IPersonaService {
    List<PersonaDTO> buscarPersonasDeRiesgo();
}
