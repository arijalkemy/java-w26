package com.example._05_covid19.service;

import com.example._05_covid19.model.DTO.PersonaConSintomaDTO;

import java.util.List;

public interface IPersonaService {
    public List<PersonaConSintomaDTO> obtenerGrupoDeRiesgo();
}
