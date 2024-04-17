package com.example._08_concesionaria.repository;

import com.example._08_concesionaria.entity.Vehicle;
import com.example._08_concesionaria.entity.VehicleService;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class VehicleRepository implements ICrudRepository<Vehicle>{
    List<Vehicle> vehicles;

    public void preList(){
        List<VehicleService> services1 = new ArrayList<>();
        services1.add(new VehicleService(new Date(), 10000, "Oil change"));
        services1.add(new VehicleService(new Date(), 20000, "Tire rotation"));

        List<VehicleService> services2 = new ArrayList<>();
        services2.add(new VehicleService(new Date(), 15000, "Brake pad replacement"));

        vehicles = new ArrayList<>();

        vehicles.add(new Vehicle("Toyota", "Corolla", new Date(), 50000,
                4, 15000.0, "USD", 2, services1));
        vehicles.add(new Vehicle("Honda", "Civic", new Date(), 60000,
                4, 18000.0, "USD", 1, services2));
    }

    public VehicleRepository(){
        preList();
    }

    @Override
    public boolean add(Vehicle vehicle) {
        vehicles.add(vehicle);

        return true;
    }

    @Override
    public List<Vehicle> get() {
        return vehicles;
    }
}
