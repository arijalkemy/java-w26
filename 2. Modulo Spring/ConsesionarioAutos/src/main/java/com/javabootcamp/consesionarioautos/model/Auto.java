package com.javabootcamp.consesionarioautos.model;

import lombok.Data;

import java.util.List;

@Data
public class Auto {
    int id;
    String brand;
    String model;
    String manufacturingDate;
    String numberOfKilometers;
    String doors;
    String price;
    String Currency;
    String countOfOwners;
    List<Service> services;
}
