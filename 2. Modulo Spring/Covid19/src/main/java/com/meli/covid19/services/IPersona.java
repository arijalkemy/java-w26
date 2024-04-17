package com.meli.covid19.services;

import com.meli.covid19.dto.PersonaDTO;

import java.util.List;

public interface IPersona {
    public List<PersonaDTO> personasEnRiesgo();
}
