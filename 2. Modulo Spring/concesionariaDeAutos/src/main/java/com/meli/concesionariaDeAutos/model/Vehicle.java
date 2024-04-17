package com.meli.concesionariaDeAutos.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class Vehicle {
    private String id;
    private String brand;
    private String model;
    private String manufacturatingDate;
    private Integer numberOfKilometers;
    private Integer doors;
    private double price;
    private String currency;
    private List<Service> services;
    private Integer countOfOwners;

    public Vehicle(String brand, String model, String manufacturatingDate, Integer numberOfKilometers, Integer doors,
                   double price, String currency, List<Service> services, Integer countOfOwners) {
        this.id = UUID.randomUUID().toString();
        this.brand = brand;
        this.model = model;
        this.manufacturatingDate = manufacturatingDate;
        this.numberOfKilometers = numberOfKilometers;
        this.doors = doors;
        this.price = price;
        this.currency = currency;
        this.services = services;
        this.countOfOwners = countOfOwners;
    }
}
