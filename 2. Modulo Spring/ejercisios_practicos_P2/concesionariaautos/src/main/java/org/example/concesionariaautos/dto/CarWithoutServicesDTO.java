package org.example.concesionariaautos.dto;

import lombok.Getter;
import org.example.concesionariaautos.model.Car;

import java.time.LocalDate;

@Getter
public class CarWithoutServicesDTO {
    private String brand;
    private String model;
    private LocalDate manufacturingDate;
    private double numberOfKilometers;
    private int doors;
    private double price;
    private String currency;
    private int countOfOwners;

    public CarWithoutServicesDTO(Car car) {
        this.brand = car.getBrand();
        this.model = car.getModel();
        this.manufacturingDate = car.getManufacturingDate();
        this.numberOfKilometers = car.getNumberOfKilometers();
        this.doors = car.getDoors();
        this.price = car.getPrice();
        this.currency = car.getCurrency();
        this.countOfOwners = car.getCountOfOwners();
    }
}
