package com.StarWars.StarWars.services;

import com.StarWars.StarWars.entity.Personaje;

import java.util.List;

public interface IStarWarsRepository {
    public List<Personaje> obtenerDatos();
}
