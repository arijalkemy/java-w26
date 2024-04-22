package com.javabootcamp.consesionarioautos.dto;

import lombok.Data;

@Data
public class AutoDTO {
    int id;
    String brand;
    String model;
    String manufacturingDate;
    String numberOfKilometers;
    String doors;
    String price;
    String currency;
    String countOfOwners;

    public AutoDTO(int id, String brand, String model, String manufacturingDate, String numberOfKilometers, String doors, String price, String currency, String countOfOwners) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.manufacturingDate = manufacturingDate;
        this.numberOfKilometers = numberOfKilometers;
        this.doors = doors;
        this.price = price;
        this.currency = currency;
        this.countOfOwners = countOfOwners;
    }
}
