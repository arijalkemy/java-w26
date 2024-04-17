package com.personajes.starwars.service;

import com.personajes.starwars.dto.PersonajeDTO;

import java.util.List;

public interface StarWarsPersonajes {

    List<PersonajeDTO> getPersonajeByName(String nombre);
}
