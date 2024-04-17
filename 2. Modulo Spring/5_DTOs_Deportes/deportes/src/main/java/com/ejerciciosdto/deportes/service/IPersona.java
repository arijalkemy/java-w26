package com.ejerciciosdto.deportes.service;

import com.ejerciciosdto.deportes.dto.PersonaDTO;

import java.util.List;

public interface IPersona {
    public List<PersonaDTO> getPersonsAndSports();
}
