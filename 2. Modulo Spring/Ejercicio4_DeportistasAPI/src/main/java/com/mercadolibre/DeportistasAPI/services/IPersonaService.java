package com.mercadolibre.DeportistasAPI.services;

import com.mercadolibre.DeportistasAPI.DTO.PersonaDTO;

import java.util.List;

public interface IPersonaService {
    public List<PersonaDTO> visualizarDeportistas();
}
