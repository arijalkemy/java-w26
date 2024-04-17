package com.personajes.starwars.repository;

import com.personajes.starwars.model.PersonajeStarWars;

import java.util.List;

public interface StarWarsRepository {

    List<PersonajeStarWars> getPersonajeByName(String nombre);
}
