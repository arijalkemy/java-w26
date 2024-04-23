package com.demospring.concesionariodeautos.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CarResponseDTO {
    private int id;
    private String brand;
    private String model;
    private String manufacturingDate;
    private double numberOfKilometres;
    private int doors;
    private double price;
    private String currency;
    private int countOfOwners;

    public CarResponseDTO(int id, String brand, String model, String manufacturingDate, double numberOfKilometres, int doors, double price, String currency, int countOfOwners) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.manufacturingDate = manufacturingDate;
        this.numberOfKilometres = numberOfKilometres;
        this.doors = doors;
        this.price = price;
        this.currency = currency;
        this.countOfOwners = countOfOwners;
    }
}
