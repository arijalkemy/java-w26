package com.practicaSpring.concesionariaDeAutos.dto;

import lombok.Getter;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
public class CarResponseDTO implements Serializable {
    private String brand;
    private String model;
    private LocalDate manufacturingDate;
    private Long numberOfKilometers;
    private Integer doors;
    private Long price;
    private String currency;
    private Integer countOfOwners;

    public CarResponseDTO(String brand, String model, LocalDate manufacturingDate, Long numberOfKilometers, Integer doors, Long price, String currency, Integer countOfOwners) {
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
