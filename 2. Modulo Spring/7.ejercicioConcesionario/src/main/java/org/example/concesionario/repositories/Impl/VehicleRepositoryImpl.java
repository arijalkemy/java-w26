package org.example.concesionario.repositories.Impl;

import org.example.concesionario.model.Vehicle;
import org.example.concesionario.repositories.IvehicleRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class VehicleRepositoryImpl implements IvehicleRepository {
    Map<Integer,Vehicle> listOfVehicles;
    Integer countOfVehicles;

    public VehicleRepositoryImpl() {
        this.listOfVehicles = new HashMap<>();
        this.countOfVehicles = 0;
    }

    @Override
    public void createVehicle(Vehicle vehicle) {
        listOfVehicles.put(countOfVehicles, vehicle);
        countOfVehicles++;

    }

    @Override
    public List<Vehicle> allVehicles() {
        return listOfVehicles.values().stream().toList();
    }


    @Override
    public Vehicle findVehicleById(int id) {
        return listOfVehicles.get(id);
    }

}
