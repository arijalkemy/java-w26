package com.bootcamp.autos.entity;

import com.bootcamp.autos.dto.VehicleDTO;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
public class Vehicle {


    private static Long contador= Long.valueOf(0);
    private Long id;
    private String brand;
    private String model;
    private LocalDate manufacturingDate;
    private String numberOfKilometers;
    private String doors;
    private Double price;
    private String currency;
    private List<Service> services;
    private String countOfOwners;

    public Vehicle(VehicleDTO vehicleDTO) {
        contador++;
        this.id = contador;
        this.brand = vehicleDTO.getBrand();
        this.model = vehicleDTO.getModel();
        this.manufacturingDate = vehicleDTO.getManufacturingDate();
        this.numberOfKilometers = vehicleDTO.getNumberOfKilometers();
        this.doors = vehicleDTO.getDoors();
        this.price =  vehicleDTO.getPrice();
        this.currency = vehicleDTO.getCurrency();
        this.countOfOwners = vehicleDTO.getCountOfOwners();
    }
}
