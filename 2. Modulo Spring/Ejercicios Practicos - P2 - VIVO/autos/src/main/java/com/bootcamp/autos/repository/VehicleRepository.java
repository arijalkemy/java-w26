package com.bootcamp.autos.repository;

import com.bootcamp.autos.dto.VehicleDTO;
import com.bootcamp.autos.entity.Vehicle;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class VehicleRepository {
    List<Vehicle> vehicles;

    public VehicleRepository() {
        vehicles = new ArrayList<>();
    }

    public Vehicle save(VehicleDTO vehicleDTO ) {
        Vehicle vehicle = new Vehicle(vehicleDTO);
        vehicles.add(vehicle);
        return vehicle;
    }

    public List<Vehicle> findAll() {
        return vehicles;
    }

    public List<Vehicle> findByProductionDate(LocalDate since, LocalDate to) {
        return vehicles.stream()
                .filter(v -> v.getManufacturingDate().isAfter(since) && v.getManufacturingDate().isBefore(to))
                .collect(Collectors.toList());
    }

    public List<Vehicle> findByPrice(Double since, Double to) {
        return vehicles.stream()
                .filter(v -> v.getPrice() >= since && v.getPrice() <= to)
                .collect(Collectors.toList());
    }

    public Vehicle findById(Long id) {
        return vehicles.stream()
                .filter(v -> v.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}
