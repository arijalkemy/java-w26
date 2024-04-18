package com.spring.concesionaria.entity;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class Vehicle {

    private Integer id;
    private String brand;
    private String model;
    private LocalDate manufacturingDate;
    private Double numberOfKilometers;
    private Integer doors;
    private Double price;
    private String currency;
    private List<VService> services;
    private static Integer idCounter = 0;

    public Vehicle(
            String brand,
            String model,
            LocalDate manufacturingDate,
            Double numberOfKilometers,
            Integer doors,
            Double price,
            String currency,
            List<VService> services
    ) {
        this.brand = brand;
        this.model = model;
        this.manufacturingDate = manufacturingDate;
        this.numberOfKilometers = numberOfKilometers;
        this.doors = doors;
        this.price = price;
        this.currency = currency;
        this.services = services;
        this.id = ++Vehicle.idCounter;
    }
}
