package org.example.starwars.repository;

import org.example.starwars.entity.Personaje;

import java.util.List;

public interface IPersonajeRepository {
    public List<Personaje> getPersonajes();
}
