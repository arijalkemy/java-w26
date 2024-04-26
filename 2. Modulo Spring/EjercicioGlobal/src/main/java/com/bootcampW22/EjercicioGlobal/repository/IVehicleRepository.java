package com.bootcampW22.EjercicioGlobal.repository;

import com.bootcampW22.EjercicioGlobal.entity.Vehicle;

import java.util.List;
import java.util.Optional;

public interface IVehicleRepository {
    List<Vehicle> findAll();
    List<Vehicle> searchById(Long id);

    List<Vehicle> searchByRange(double min, double max);

    Optional<Vehicle> changeData(Long id, String fuel_type);

    List<Vehicle> searchByFuel(String fuel_type);

    Double searchBrandAvg(String brand);
}
