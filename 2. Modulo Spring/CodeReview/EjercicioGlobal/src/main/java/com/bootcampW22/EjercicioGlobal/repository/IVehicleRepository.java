package com.bootcampW22.EjercicioGlobal.repository;

import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import lombok.experimental.FieldDefaults;

import java.util.List;

public interface IVehicleRepository {
    List<Vehicle> findAll();
    public boolean save(Vehicle vehicle);
    public boolean exist(Long id);
    public Vehicle getById(Long id);
    public void updateVehicle(Vehicle vehicle);
    public boolean deleteVehicle(Long id);
}
