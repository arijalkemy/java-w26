package com.bootcampW22.EjercicioGlobal.repository.interfaces;

import com.bootcampW22.EjercicioGlobal.entity.Vehicle;

import java.util.List;

public interface IVehicleRepository {

    List<Vehicle> findAll();

    void save(Vehicle save);

}
