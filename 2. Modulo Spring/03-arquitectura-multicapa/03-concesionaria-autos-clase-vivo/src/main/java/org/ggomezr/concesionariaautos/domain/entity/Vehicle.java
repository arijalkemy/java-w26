package org.ggomezr.concesionariaautos.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class Vehicle {
    private int id;
    private String brand;
    private String model;
    private LocalDate manufacturingDate;
    private String numberOfKilometers;
    private String doors;
    private String price;
    private String currency;
    private List<Service> services;
    private String counterOfOwners;

    private static int lastId;

    public Vehicle(int id, String brand, String model, LocalDate manufacturingDate, String numberOfKilometers, String doors, String price, String currency, List<Service> services, String counterOfOwners) {
        this.id = ++lastId;
        this.brand = brand;
        this.model = model;
        this.manufacturingDate = manufacturingDate;
        this.numberOfKilometers = numberOfKilometers;
        this.doors = doors;
        this.price = price;
        this.currency = currency;
        this.services = services;
        this.counterOfOwners = counterOfOwners;
    }
}
