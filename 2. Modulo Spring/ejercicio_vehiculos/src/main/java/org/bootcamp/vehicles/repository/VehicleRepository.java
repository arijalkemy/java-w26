package org.bootcamp.vehicles.repository;

import org.bootcamp.vehicles.model.Vehicle;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class VehicleRepository {

    private List<Vehicle> vehicleList;
    private Integer counter;

    public VehicleRepository() {
        counter = 1;
        vehicleList = new ArrayList<>();
    }


    public Vehicle save (Vehicle vehicle){
        vehicle.setId(counter++);
        vehicleList.add(vehicle);
        return vehicle;
    }

    public List<Vehicle> findAll(){
        return vehicleList;
    }

    public Vehicle findById(Integer id){
        return vehicleList.stream()
                .filter(vehicle -> vehicle.getId().equals(id))
                .findFirst().orElse(new Vehicle());
    }

    public List<Vehicle> findBetweenManufacturingDate (LocalDate sinceDate, LocalDate toSince){
        return vehicleList.stream()
                .filter(vehicle -> vehicle.getManufacturingDate().isAfter(sinceDate)
                        && vehicle.getManufacturingDate().isBefore(toSince))
                .toList();
    }

    public List<Vehicle> findBetweenPrice (Double sincePrice, Double toPrice){
        return vehicleList.stream()
                .filter(vehicle -> vehicle.getPrice() >= sincePrice && vehicle.getPrice() <= toPrice)
                .toList();
    }

}
