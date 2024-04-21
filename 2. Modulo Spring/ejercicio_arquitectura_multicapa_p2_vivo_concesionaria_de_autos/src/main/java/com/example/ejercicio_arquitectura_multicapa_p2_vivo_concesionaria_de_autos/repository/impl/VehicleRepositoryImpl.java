package com.example.ejercicio_arquitectura_multicapa_p2_vivo_concesionaria_de_autos.repository.impl;

import com.example.ejercicio_arquitectura_multicapa_p2_vivo_concesionaria_de_autos.entity.Service;
import com.example.ejercicio_arquitectura_multicapa_p2_vivo_concesionaria_de_autos.entity.Vehicle;
import com.example.ejercicio_arquitectura_multicapa_p2_vivo_concesionaria_de_autos.repository.IVehicleRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class VehicleRepositoryImpl implements IVehicleRepository {
    private List<Vehicle> vehicles;

    public VehicleRepositoryImpl() {
        vehicles = new ArrayList<>() {{
           add(new Vehicle(
                1,
                   "Ford",
                   "Bronco",
                   "2022",
                   "40000",
                   "4",
                   "50000",
                   "USD",
                   new ArrayList<>(){{
                       add(new Service(
                               "2023-10-31",
                               "20000",
                               "Overall check"
                       ));
                   }},
                   "1"
           ));
        }};
    }

    public List<Vehicle> findAll() {
        return vehicles;
    }

    public Optional<Vehicle> findById(int id) {
        return vehicles.stream().filter(
          v -> v.getId() == id
        ).findFirst();
    }

    public List<Vehicle> findAllByManufacturingDate(int since, int to) {
        return vehicles.stream()
            .filter(v ->
                Integer.parseInt(v.getManufacturingDate()) >= since &&
                    Integer.parseInt(v.getManufacturingDate()) <= to)
            .toList();
    }

    public List<Vehicle> findAllByPrice(int min, int max) {
        return vehicles.stream()
            .filter(vehicle ->
                    Integer.parseInt(vehicle.getPrice()) >= min &&
                        Integer.parseInt(vehicle.getPrice()) <= max
                ).toList();
    }

    public void createVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }
}
