package com.mercadolibre.Covid19API.services;

import com.mercadolibre.Covid19API.DTO.PersonaDTO;

import java.util.List;

public interface IPersonaService {
    public List<PersonaDTO> visualizarPersonasGrupoDeRiesgo();
}
