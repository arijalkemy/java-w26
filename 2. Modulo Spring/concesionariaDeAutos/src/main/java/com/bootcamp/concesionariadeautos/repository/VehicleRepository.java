package com.bootcamp.concesionariadeautos.repository;

import com.bootcamp.concesionariadeautos.entity.Vehicle;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class VehicleRepository {

    private final List<Vehicle> listVehicles = new ArrayList<>();


    public Vehicle add(Vehicle vehicle){

        this.listVehicles.add(vehicle);

        return vehicle;
    }

    public List<Vehicle> getAll(){
        return this.listVehicles;
    }

    public Vehicle getById(int id){

    }


}
