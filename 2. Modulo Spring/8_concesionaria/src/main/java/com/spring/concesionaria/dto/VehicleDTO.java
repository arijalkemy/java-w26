package com.spring.concesionaria.dto;

import lombok.Getter;

import java.util.List;

@Getter
public class VehicleDTO {

    private String brand;
    private String model;
    private String manufacturingDate;
    private Double numberOfKilometers;
    private Integer doors;
    private Double price;
    private String currency;
    private List<VServiceDTO> services;

    public VehicleDTO(
            String brand,
            String model,
            String manufacturingDate,
            Double numberOfKilometers,
            Integer doors,
            Double price,
            String currency,
            List<VServiceDTO> services
    ) {
        this.brand = brand;
        this.model = model;
        this.manufacturingDate = manufacturingDate;
        this.numberOfKilometers = numberOfKilometers;
        this.doors = doors;
        this.price = price;
        this.currency = currency;
        this.services = services;
    }
}
