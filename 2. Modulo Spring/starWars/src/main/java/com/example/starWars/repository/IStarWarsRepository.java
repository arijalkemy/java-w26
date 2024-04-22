package com.example.starWars.repository;

import com.example.starWars.model.Personaje;

import java.util.List;

public interface IStarWarsRepository {

    public List<Personaje> obtenerPersonajes();
}
