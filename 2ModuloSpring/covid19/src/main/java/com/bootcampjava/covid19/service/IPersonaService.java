package com.bootcampjava.covid19.service;

import com.bootcampjava.covid19.model.DTOs.PersonaRiesgoDTO;

import java.util.List;

public interface IPersonaService {
    public List<PersonaRiesgoDTO> obtenerPersonasConRiesgo();
}
