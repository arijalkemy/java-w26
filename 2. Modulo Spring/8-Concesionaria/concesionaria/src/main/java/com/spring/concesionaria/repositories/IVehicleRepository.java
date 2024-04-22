package com.spring.concesionaria.repositories;

import com.spring.concesionaria.entities.Vehicle;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public interface IVehicleRepository {
    List<Vehicle> vehicles = new ArrayList<>(Arrays.asList(new Vehicle(1L, "Fiat", "Palio",
            LocalDate.of(2015, 2, 2), 34000, 4, 3000000,
            "AR", null, 2)));

    Vehicle addVehicle(Vehicle vehicle);
    Optional<Vehicle> searchByBrandAndModel(String brand, String model);

    Long searchLastId();

    List<Vehicle> searchAllVehicles();
    List<Vehicle> searchSinceDate(LocalDate sinceDate);
    List<Vehicle> searchSincePrice(double sincePrice);
    Optional<Vehicle> searchById(Long id);

}
