package com.ejercicio.starwars.service;

import com.ejercicio.starwars.dto.PersonajeDTO;

import java.util.List;


public interface IPersonajeService {
    public List<PersonajeDTO> getPersonajePorNombre(String nombre);
}
