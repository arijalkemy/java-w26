package com.EjercicioSpring.Ejercicio8_StarWars.repository;

import java.util.List;

public interface ICRUD<T> {

    public List<T> getAll();

}
