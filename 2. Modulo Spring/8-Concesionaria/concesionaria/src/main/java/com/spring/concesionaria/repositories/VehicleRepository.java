package com.spring.concesionaria.repositories;

import com.spring.concesionaria.entities.Vehicle;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public class VehicleRepository implements IVehicleRepository {
    @Override
    public Vehicle addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
        return vehicle;
    }

    @Override
    public Optional<Vehicle> searchByBrandAndModel(String brand, String model) {
        return vehicles.stream().filter(v -> v.getBrand().equals(brand) && v.getModel().equals(model))
                .findFirst();
    }

    public Long searchLastId(){
        Long lastId = vehicles.stream().mapToLong(v -> v.getId()).max().getAsLong();
        if(lastId == null){
            return 0L;
        }
        return lastId;
    }

    @Override
    public List<Vehicle> searchAllVehicles() {
        return vehicles;
    }

    @Override
    public List<Vehicle> searchSinceDate(LocalDate sinceDate) {
        return vehicles.stream().filter(v -> v.getManufacturingDate().isAfter(sinceDate)).toList();
    }

    @Override
    public List<Vehicle> searchSincePrice(double sincePrice) {
        return vehicles.stream().filter(v -> v.getPrice()>sincePrice).toList();
    }

    @Override
    public Optional<Vehicle> searchById(Long id) {
        return vehicles.stream().filter(v -> v.getId().equals(id)).findFirst();
    }
}
