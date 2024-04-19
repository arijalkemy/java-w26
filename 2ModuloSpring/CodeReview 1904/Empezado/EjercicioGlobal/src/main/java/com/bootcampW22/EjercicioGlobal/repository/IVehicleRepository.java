package com.bootcampW22.EjercicioGlobal.repository;

import com.bootcampW22.EjercicioGlobal.entity.Vehicle;

import java.util.ArrayList;
import java.util.List;

public interface IVehicleRepository {
    List<Vehicle> findAll();
    Vehicle getLast();
    void addOne(Vehicle vehicle);

    List<Vehicle> findByFuelType(String fuelType);

    List <Vehicle> findByDimensions(double minHeight, double maxHeight, double minWidth, double maxWidth);
}
