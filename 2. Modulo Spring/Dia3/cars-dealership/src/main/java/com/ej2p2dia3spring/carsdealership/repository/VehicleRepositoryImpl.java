package com.ej2p2dia3spring.carsdealership.repository;

import com.ej2p2dia3spring.carsdealership.entity.Vehicle;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class VehicleRepositoryImpl implements IVehicleRepository {
    private List<Vehicle> vehicles = new ArrayList<>();

    @Override
    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    @Override
    public List<Vehicle> getAllVehicles() {
        return vehicles;
    }

    @Override
    public List<Vehicle> getVehiclesByManufacturingDate(String fromDate, String toDate) {
        List<Vehicle> filteredVehicles = new ArrayList<>();
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getManufacturingDate().compareTo(fromDate) >= 0 &&
                    vehicle.getManufacturingDate().compareTo(toDate) <= 0) {
                filteredVehicles.add(vehicle);
            }
        }
        return filteredVehicles;
    }

    @Override
    public List<Vehicle> getVehiclesByPrice(int minPrice, int maxPrice) {
        List<Vehicle> filteredVehicles = new ArrayList<>();
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getPrice() >= minPrice && vehicle.getPrice() <= maxPrice) {
                filteredVehicles.add(vehicle);
            }
        }
        return filteredVehicles;
    }

    @Override
    public Vehicle getVehicleById(int id) {
        for (Vehicle vehicle : vehicles) {
            if (id == vehicle.getId()) {
                return vehicle;
            }
        }
        return null;
    }
}
