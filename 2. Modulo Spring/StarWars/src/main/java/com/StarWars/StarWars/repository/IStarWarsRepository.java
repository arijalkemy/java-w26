package com.StarWars.StarWars.repository;

import com.StarWars.StarWars.entity.Personaje;

import java.util.List;

public interface IStarWarsRepository {
    List<Personaje> obtenerPesonajes();

}
