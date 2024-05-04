package com.concesionaria.autos.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Vehicle {
    private int id;
    private String brand;
    private String model;
    private String manufacturingDate;
    private int numberOfKilometers;
    private int doors;
    private double price;
    private String currency;
    private List<Service> services;
    private int countOfOwners;
}
