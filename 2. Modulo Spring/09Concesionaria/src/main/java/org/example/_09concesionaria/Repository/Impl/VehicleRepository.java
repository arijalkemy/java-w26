package org.example._09concesionaria.Repository.Impl;

import org.example._09concesionaria.Model.Vehicle;
import org.example._09concesionaria.Repository.IRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class VehicleRepository implements IRepository {

    private List<Vehicle> vehicles;

    public VehicleRepository() {
        this.vehicles = new ArrayList<>();
    }

    @Override
    public boolean save(Vehicle vehicle) {
        vehicle.setId(vehicles.size());
        return vehicles.add(vehicle);
    }

    @Override
    public List<Vehicle> findAll() {
        return vehicles;
    }


}
