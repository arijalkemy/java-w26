package com.demospring.concesionariodeautos.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class CarDTO {
    private static int idAutos = 0;
    private int id;
    private String brand;
    private String model;
    private String manufacturingDate;
    private double numberOfKilometres;
    private int doors;
    private double price;
    private String currency;
    private List<ServiceDTO> services;
    private int countOfOwners;

    public CarDTO(String brand, String model, String manufacturingDate, double numberOfKilometres, int doors, double price, String currency, List<ServiceDTO> services, int countOfOwners) {
        idAutos++;
        this.id = idAutos;
        this.brand = brand;
        this.model = model;
        this.manufacturingDate = manufacturingDate;
        this.numberOfKilometres = numberOfKilometres;
        this.doors = doors;
        this.price = price;
        this.currency = currency;
        this.services = services;
        this.countOfOwners = countOfOwners;
    }
}
