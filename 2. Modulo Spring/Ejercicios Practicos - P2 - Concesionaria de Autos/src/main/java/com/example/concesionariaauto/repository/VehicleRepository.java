package com.example.concesionariaauto.repository;

import com.example.concesionariaauto.entity.VehicleEntity;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class VehicleRepository implements IVehilcesRepository{
    List<VehicleEntity> vehicleList= new ArrayList<>();

    @Override
    public VehicleEntity addVehicle(VehicleEntity vehicle) {
        vehicleList.add(vehicle);
        return vehicle;
    }

    @Override
    public List<VehicleEntity> listVehicles() {
        return vehicleList
                .stream()
                .filter(vehicle -> vehicle.getNumberOfKilometers() > 0)
                .toList();
    }

    @Override
    public List<VehicleEntity> listDateVehicles(LocalDate since, LocalDate to) {
        return vehicleList
                .stream()
                .filter(vehicle ->
                        vehicle.getManofacturingDate().isAfter(since) && vehicle.getManofacturingDate().isBefore(to)
                ).toList();
    }

    @Override
    public List<VehicleEntity> listPriceVehicles(int since, int to) {
        return vehicleList
                .stream()
                .filter(vehicle ->
                        vehicle.getPrice() >= since && vehicle.getPrice() <= to
                ).toList();
    }

    @Override
    public VehicleEntity getVehicleById(UUID id) {
        return vehicleList
                .stream()
                .filter(vehicle -> vehicle.getId().equals(id))
                .findFirst().orElse(null);
    }

}
