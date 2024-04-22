package com.bootcamp.autos.dto;

import com.bootcamp.autos.entity.Vehicle;
import lombok.Data;

import java.time.LocalDate;

@Data
public class VehicleDTO {
    private String brand;
    private String model;
    private LocalDate manufacturingDate;
    private String numberOfKilometers;
    private String doors;
    private Double price;
    private String currency;
    private String countOfOwners;

    public VehicleDTO(Vehicle vehicle) {
        this.brand = vehicle.getBrand();
        this.model = vehicle.getModel();
        this.manufacturingDate = vehicle.getManufacturingDate();
        this.numberOfKilometers = vehicle.getNumberOfKilometers();
        this.doors = vehicle.getDoors();
        this.price = vehicle.getPrice();
        this.currency = vehicle.getCurrency();
        this.countOfOwners = vehicle.getCountOfOwners();
    }
}
