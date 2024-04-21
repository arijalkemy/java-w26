package com.example.demo.repository;

import com.example.demo.entity.Vehicle;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@Scope("singleton")
public class VehicleRepositoryImpl implements IVehicleRepository {

    List<Vehicle> vehicles;

    public VehicleRepositoryImpl() {
        vehicles = new ArrayList<>();
    }

    @Override
    public List<Vehicle> getVehicles() {
        return vehicles;
    }
}
