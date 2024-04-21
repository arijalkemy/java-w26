package com.example.concesionariaautos.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Data
@NoArgsConstructor
public class Auto {

    private Integer id;
    private String brand;
    private String model;
    private String manufacturingDate;
    private Integer numberOfKm;
    private Integer doors;
    private Integer price;
    private String currency;
    private List<Service> serviceList;
    private Integer countOfOwners;

    public Auto(String brand, String model, String manufacturingDate, Integer numberOfKm, Integer doors, Integer price, String currency, List<Service> serviceList, Integer countOfOwners) {
        this.brand = brand;
        this.model = model;
        this.manufacturingDate = manufacturingDate;
        this.numberOfKm = numberOfKm;
        this.doors = doors;
        this.price = price;
        this.currency = currency;
        this.serviceList = serviceList;
        this.countOfOwners = countOfOwners;
    }

    public LocalDate getLocalDate(DateTimeFormatter formatter) {
        return LocalDate.parse(getManufacturingDate(), formatter);
    }
}
