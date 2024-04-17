package com.practicaSpring.concesionariaDeAutos.model;

import lombok.Getter;

import java.time.LocalDate;
import java.util.List;

@Getter
public class Car {
    private Long id;
    private String brand;
    private String model;
    private LocalDate manufacturingDate;
    private Long numberOfKilometers;
    private Integer doors;
    private Long price;
    private String currency;
    private List<Service> services;
    private Integer countOfOwners;

    public Car(Long id, String brand, String model, LocalDate manufacturingDate, Long numberOfKilometers, Integer doors, Long price, String currency, List<Service> services, Integer countOfOwners) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.manufacturingDate = manufacturingDate;
        this.numberOfKilometers = numberOfKilometers;
        this.doors = doors;
        this.price = price;
        this.currency = currency;
        this.services = services;
        this.countOfOwners = countOfOwners;
    }
}
