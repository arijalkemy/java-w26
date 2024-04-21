package com.example.concesionariaautos.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
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

    public LocalDate getLocalDate(DateTimeFormatter formatter) {
        return LocalDate.parse(getManufacturingDate(), formatter);
    }
}
