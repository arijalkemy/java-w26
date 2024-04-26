package com.bootcampW22.EjercicioGlobal.repository;

import com.bootcampW22.EjercicioGlobal.entity.Vehicle;

import java.util.List;
import java.util.Optional;

public interface IVehicleRepository {
    List<Vehicle> findAll();

    Vehicle saveVehicle(Vehicle vehicle);

    boolean existsById(Long id);

    List<Vehicle> findByColorAndYear(String color, int year);

    List<Vehicle> findByBrand(String brand);

    Vehicle findById(Long id);

    List<Vehicle> findByFuelType(String fuelType);

    List<Vehicle> findByTransmission(String type);

    void deleteById(Long id);

    List<Vehicle> findByDimensions(double min_length, double max_length, double min_width, double max_width);
}
