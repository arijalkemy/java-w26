package com.ejercicio.concesionariadeautos.entity;

import java.time.LocalDate;
import java.util.List;

public class Vehicle {
    private int id;
    private String brand;
    private String model;
    private LocalDate manufacturingDate;
    private int numberOfKilometers;
    private int doors;
    private float price;
    private List<Service> services;
    private int countOfOwners;
}
