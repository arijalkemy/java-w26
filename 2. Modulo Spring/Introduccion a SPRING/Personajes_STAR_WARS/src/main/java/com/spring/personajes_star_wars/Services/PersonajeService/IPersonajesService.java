package com.spring.personajes_star_wars.Services.PersonajeService;

import com.spring.personajes_star_wars.Dtos.PersonajeDto;
import com.spring.personajes_star_wars.Models.Personaje;

import java.util.List;

public interface IPersonajesService {
    List<PersonajeDto> findPersonajes(String nombre);
    List<Personaje> findAll();
}
