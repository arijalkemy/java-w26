package com.meli.concesionariaDeAutos.repository;

import com.meli.concesionariaDeAutos.model.Vehicle;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class VehicleRepository implements IVehicleRepository{
    private final List<Vehicle> vehicleList = new ArrayList<>();

    public void saveVehicle(Vehicle vehicle){
        vehicleList.add(vehicle);
    }

    public List<Vehicle> getVehicles() {
        return vehicleList;
    }

    public Vehicle getVehicleById(String id) {
        return vehicleList.stream()
                .filter(vehicle -> vehicle.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public List<Vehicle> getVehiclesByDate(String since, String to) {
        LocalDate sinceDate = LocalDate.parse(since);
        LocalDate toDate = LocalDate.parse(to);

        return vehicleList.stream()
                .filter(vehicle ->
                        LocalDate.parse(vehicle.getManufacturatingDate()).isAfter(sinceDate)
                                && LocalDate.parse(vehicle.getManufacturatingDate()).isBefore(toDate))
                .toList();
    }

    public List<Vehicle> getVehiclesByPrice(double since, double to) {
        return vehicleList.stream()
                .filter(vehicle -> vehicle.getPrice() >= since && vehicle.getPrice() <= to)
                .toList();
    }

}
