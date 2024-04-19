package org.responseentity.agenciaautos.repository;

import org.responseentity.agenciaautos.entity.VehicleEntity;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class VehiculeRepository {
    List<VehicleEntity> vehicles;

    public VehiculeRepository() {
        this.vehicles = new ArrayList<>();
    }

    public List<VehicleEntity> getAllVehicles(){
        return vehicles;
    }

    public VehicleEntity addVehicle(VehicleEntity vehicleEntity){
        vehicles.add(vehicleEntity);
        return vehicleEntity;
    }

    public List<VehicleEntity> filterByPriceRange(int priceLowRange, int priceHighRange){
        return vehicles
                .stream()
                .filter(x -> x.getPrice() >= priceLowRange && x.getPrice() <= priceHighRange)
                .toList();
    }

    public List<VehicleEntity> filterByDateRange(LocalDate dateLowRange, LocalDate dateHighRange){
        return vehicles
                .stream()
                .filter(x -> x.getManufacturingDate().isAfter(dateLowRange)
                        && x.getManufacturingDate().isBefore(dateHighRange)
                )
                .toList();
    }

    public VehicleEntity getVehicleById(UUID id){
        return vehicles
                .stream()
                .filter(vehicleEntity -> vehicleEntity.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}
