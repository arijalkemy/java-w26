package com.ejercicio.concesionariadeautos.repository.interfaces;

import com.ejercicio.concesionariadeautos.entity.Vehicle;

import java.util.List;

public interface IVehicleRepository {
    Vehicle add(Vehicle vehicle);
    List<Vehicle> getAll();
    Vehicle getById(int id);
}
