package com.meli.concesionariaDeAutos.dto;

import com.meli.concesionariaDeAutos.model.Service;
import lombok.Data;

import java.util.List;

@Data
public class VehicleDto {
    private String brad;
    private String model;
    private String manufacturatingDate;
    private Integer numberOfKilometers;
    private Integer doors;
    private double price;
    private String currency;
    private Integer countOfOwners;

    public VehicleDto(String brad, String model, String manufacturatingDate, Integer numberOfKilometers, Integer doors,
                   double price, String currency, Integer countOfOwners) {
        this.brad = brad;
        this.model = model;
        this.manufacturatingDate = manufacturatingDate;
        this.numberOfKilometers = numberOfKilometers;
        this.doors = doors;
        this.price = price;
        this.currency = currency;
        this.countOfOwners = countOfOwners;
    }
}
