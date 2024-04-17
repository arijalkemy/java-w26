package com.StarWars.StarWars.services;

import com.StarWars.StarWars.dto.PersonajeDTO;
import com.StarWars.StarWars.entity.Personaje;

import java.util.List;

public interface IStarWarsService {
    List<Personaje> obtenerPersonajes();
    List<Personaje> buscarPersonajes(String nombre);
}
