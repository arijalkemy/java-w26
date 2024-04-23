package org.bootcamp.concesionary.repository;

import org.bootcamp.concesionary.model.Vehicle;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class VehicleRepositoryImpl implements VehicleRepository {
    List<Vehicle> vehicles;

    public List<Vehicle> getAllVehicles() {
        return vehicles;
    }

    public Vehicle getVehicleByIndex(UUID index) {
        return vehicles.stream().filter(vehicle -> vehicle.getId().equals(index)).findFirst().orElse(null);
    }

    public void setVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    public List<Vehicle> filterVehiclesByManufacturingDateRange(String startDate, String endDate) {
        return vehicles.stream().filter(vehicle -> vehicle.getManufacturingDate().compareTo(startDate) >= 0 && vehicle.getManufacturingDate().compareTo(endDate) <= 0).toList();
    }

    public List<Vehicle> filterVehiclesByPriceRange(Integer startPrice, Integer endPrice) {
        return vehicles.stream().filter(vehicle -> vehicle.getPrice() >= startPrice && vehicle.getPrice() <= endPrice).toList();
    }
}
