package com.bootcampW22.EjercicioGlobal.repository;

import com.bootcampW22.EjercicioGlobal.entity.Vehicle;

import java.util.List;
import java.util.Optional;

public interface IVehicleRepository {
    void save(Vehicle vehicle);

    void update(Long id, Vehicle vehicle);

    void delete(Long id);
    Optional<Vehicle> findById(Long id);

    List<Vehicle> findAll();
}
