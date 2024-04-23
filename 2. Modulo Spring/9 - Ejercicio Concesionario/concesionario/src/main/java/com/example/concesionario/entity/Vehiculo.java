package com.example.concesionario.entity;

import lombok.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vehiculo {
    private Integer id;
    private String brand;
    private String model;
    private LocalDate manufactoringDate;
    private int numbersOfKilometers;
    private int doors;
    private double price;
    private String currency;
    private List<Service> services;
    private int countOfOwners;
}
