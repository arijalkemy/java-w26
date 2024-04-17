package com.spring.personajes_star_wars.Repository.PersonajeRepository;

import com.spring.personajes_star_wars.Models.Personaje;

import java.util.List;

public interface IPersonajeRepository {
    List<Personaje> findByName(String name);
}
