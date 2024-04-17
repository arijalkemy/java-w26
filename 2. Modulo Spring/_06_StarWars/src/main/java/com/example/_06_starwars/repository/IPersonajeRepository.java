package com.example._06_starwars.repository;

import com.example._06_starwars.dto.PersonajeDTO;
import com.example._06_starwars.entity.Personaje;

import java.util.List;

public interface IPersonajeRepository {
    public List<Personaje> obtenerPersonajes();
}
