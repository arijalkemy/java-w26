package com.example._08_concesionaria.dto;

import com.example._08_concesionaria.entity.VehicleService;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter @Setter
public class VehicleDTO {
    private String brand;
    private String model;
    private Date manufacturingDate;
    private int numberOfKilometers;
    private int doors;
    private double price;
    private String currency;
    private List<VehicleServiceDTO> services;
    private int countOfOwners;

    public VehicleDTO() {
    }

    public VehicleDTO(String brand, String model, Date manufacturingDate, int numberOfKilometers, int doors, double price, String currency, int countOfOwners, List<VehicleServiceDTO> services) {
        this.brand = brand;
        this.model = model;
        this.manufacturingDate = manufacturingDate;
        this.numberOfKilometers = numberOfKilometers;
        this.doors = doors;
        this.price = price;
        this.currency = currency;
        this.countOfOwners = countOfOwners;
        this.services = services;
    }
}
