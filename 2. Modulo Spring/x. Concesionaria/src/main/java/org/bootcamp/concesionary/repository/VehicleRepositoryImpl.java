package org.bootcamp.concesionary.repository;

import org.bootcamp.concesionary.model.Vehicle;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Repository
public class VehicleRepositoryImpl implements VehicleRepository {
    List<Vehicle> vehicles = new ArrayList<>();


    @Override
    public List<Vehicle> getAllVehicles() {
        return vehicles;
    }

    @Override
    public Vehicle getVehicleById(String id) {
        return vehicles.stream().filter(vehicle -> vehicle.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    @Override
    public List<Vehicle> getVehiclesBetweenDates(Date since, Date to) {
        return vehicles.stream().filter(vehicle -> vehicle.getManufacturingDate().before(to) && vehicle.getManufacturingDate().after(since)).toList();
    }

    @Override
    public List<Vehicle> getVehiclesBetweenPrices(Integer since, Integer to) {
        return vehicles.stream().filter(vehicle -> vehicle.getPrice() >= since && vehicle.getPrice() <= to).toList();
    }
}
