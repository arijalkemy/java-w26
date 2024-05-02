package org.example.concesionario.model;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;


public class Vehicle {
    private String brand;
    private String model;
    private LocalDate manufacturing;
    private int numberOfKilometers;
    private int doors;
    private double price;
    private String currency;
    private int numberOfOwners;
    private List<Service> service;

    public Vehicle(String brand, String model, LocalDate manufacturing, int numberOfKilometers, int doors, double price, String currency, int numberOfOwners, List<Service> service) {
        this.brand = brand;
        this.model = model;
        this.manufacturing = manufacturing;
        this.numberOfKilometers = numberOfKilometers;
        this.doors = doors;
        this.price = price;
        this.currency = currency;
        this.numberOfOwners = numberOfOwners;
        this.service = service;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public LocalDate getManufacturing() {
        return manufacturing;
    }

    public void setManufacturing(LocalDate manufacturing) {
        this.manufacturing = manufacturing;
    }

    public int getNumberOfKilometers() {
        return numberOfKilometers;
    }

    public void setNumberOfKilometers(int numberOfKilometers) {
        this.numberOfKilometers = numberOfKilometers;
    }

    public int getDoors() {
        return doors;
    }

    public void setDoors(int doors) {
        this.doors = doors;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public int getNumberOfOwners() {
        return numberOfOwners;
    }

    public void setNumberOfOwners(int numberOfOwners) {
        this.numberOfOwners = numberOfOwners;
    }

    public List<Service> getService() {
        return service;
    }

    public void setService(List<Service> service) {
        this.service = service;
    }
}
