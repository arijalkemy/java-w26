package com.ej2p2dia3spring.carsdealership.entity;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Vehicle {
    private int id;
    private String brand;
    private String model;
    private String manufacturingDate;
    private int numberOfKilometers;
    private int doors;
    private int price;
    private String currency;
    private Services services;
    private int countOfOwners;

    public Vehicle() {
    }

    public Vehicle(int id, String brand, String model, String manufacturingDate, int numberOfKilometers,
                   int doors, int price, String currency, Services services, int countOfOwners) {
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
