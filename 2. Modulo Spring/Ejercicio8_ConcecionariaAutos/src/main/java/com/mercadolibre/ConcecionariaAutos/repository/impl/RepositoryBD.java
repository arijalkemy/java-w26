package com.mercadolibre.ConcecionariaAutos.repository.impl;

import com.mercadolibre.ConcecionariaAutos.entity.Vehicle;
import com.mercadolibre.ConcecionariaAutos.repository.IRepositoryBD;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class RepositoryBD implements IRepositoryBD {
    List<Vehicle> vehicles = new ArrayList<>();

    @Override
    public boolean saveVehicle(Vehicle vehicle){
        vehicles.add(vehicle);
        return true;
    }
    @Override
    public List<Vehicle> getAllVehicles(){
        return vehicles;
    }
    @Override
    public List<Vehicle> getVehiclesByManufacturingDate(LocalDate since, LocalDate to){
        return vehicles.stream().filter(
                vehicle -> vehicle.getManufacturingDate().isAfter(since)
                    && vehicle.getManufacturingDate().isBefore(to)).toList();
    }
    @Override
    public List<Vehicle> getVehiclesByPrice(double since, double to){
        return vehicles.stream().filter(
                vehicle -> vehicle.getPrice() >= since && vehicle.getPrice() <= to).toList();
    }
    @Override
    public Vehicle getVehicleById(int id){
        return vehicles.stream().filter(
                vehicle -> vehicle.getId()==id).findFirst().orElse(null);
    }
}
