package com.StarWars.StarWars.services;

import com.StarWars.StarWars.dto.PersonajeDTO;

import java.util.List;

public interface IStarWarsService {
    List<PersonajeDTO> obtenerPersonajes();
    List<PersonajeDTO> buscarPersonajes(String nombre);
}
