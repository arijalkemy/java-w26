package com.bootcamp.concesionariadeautos.entity;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Vehicle {

    private static int contador = 0;

    public Vehicle(){
        this.id = contador;
        contador++;
    }

    public Vehicle(String brand, String model, Date manufacturingDate, int numberOfKilometers, int doors, double price, String currency, int countOfOwners, List<Service> services) {
        this.id = contador;
        contador++;
        this.brand = brand;
        this.model = model;
        this.manufacturingDate = manufacturingDate;
        this.numberOfKilometers = numberOfKilometers;
        this.doors = doors;
        this.price = price;
        this.currency = currency;
        this.countOfOwners = countOfOwners;
        this.services = services;
    }

    private int id;
    private String brand;
    private String model;
    private Date manufacturingDate;
    private int numberOfKilometers;
    private int doors;
    private double price;
    private String currency;
    private int countOfOwners;
    private List<Service> services;
}
