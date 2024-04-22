package com.bootcampW22.EjercicioGlobal.repository;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;

import java.util.List;
import java.util.Optional;

public interface IVehicleRepository {
    List<Vehicle> findAll();
    Optional<Vehicle> findOne(Long id);
    void createVehicle(Vehicle vehicle);
    List<Vehicle> findByColorYear(String color, int year);

    Vehicle updateFuel(Vehicle vehicle, Long id);
}
