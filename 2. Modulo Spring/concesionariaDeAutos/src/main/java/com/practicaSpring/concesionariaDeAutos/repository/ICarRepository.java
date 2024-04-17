package com.practicaSpring.concesionariaDeAutos.repository;

import com.practicaSpring.concesionariaDeAutos.dto.CarInputDTO;
import com.practicaSpring.concesionariaDeAutos.model.Car;

import java.util.List;

public interface ICarRepository {
    List<Car> findAll();
    void save(CarInputDTO car);

    Car findCarById(Long id);
}
