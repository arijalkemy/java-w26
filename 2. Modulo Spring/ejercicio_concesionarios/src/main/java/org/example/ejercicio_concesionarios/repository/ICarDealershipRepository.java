package org.example.ejercicio_concesionarios.repository;

import org.example.ejercicio_concesionarios.entity.Car;

import java.util.*;

public interface ICarRepository {
    public List<Car> findAll();
    public Car findById(int id);
}
