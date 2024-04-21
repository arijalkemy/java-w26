package com.example.ejercicio_arquitectura_multicapa_p2_vivo_concesionaria_de_autos.repository;

import com.example.ejercicio_arquitectura_multicapa_p2_vivo_concesionaria_de_autos.entity.Vehicle;

import java.util.List;
import java.util.Optional;

public interface IVehicleRepository {
    public List<Vehicle> findAll();
    public Optional<Vehicle> findById(int id);
    public void createVehicle(Vehicle vehicle);
    public List<Vehicle> findAllByManufacturingDate(int since, int to);
    public List<Vehicle> findAllByPrice(int min, int max);
}
