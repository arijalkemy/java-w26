package com.example.concesionaria.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vehicle {

    private Integer id;
    private String brand;
    private String model;
    private LocalDate manufacturingDate;
    private Double numberOfKilometers;
    private Integer doors;
    private Double price;
    private String currency;
    private List<Services> services;
    private Integer countOfOwners;


}
