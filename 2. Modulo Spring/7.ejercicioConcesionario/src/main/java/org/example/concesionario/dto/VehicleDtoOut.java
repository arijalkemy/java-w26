package org.example.concesionario.dto;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class VehicleDtoOut {
    private String brand;
    private String model;
    @DateTimeFormat(
            pattern = "yyyy-MM-dd"
    )
    private LocalDate manufacturing;
    private int numberOfKilometers;
    private int doors;
    private double price;
    private String currency;
    private int numberOfOwners;

    public VehicleDtoOut(String brand, String model, LocalDate manufacturing, int numberOfKilometers, int doors, double price, String currency, int numberOfOwners) {
        this.brand = brand;
        this.model = model;
        this.manufacturing = manufacturing;
        this.numberOfKilometers = numberOfKilometers;
        this.doors = doors;
        this.price = price;
        this.currency = currency;
        this.numberOfOwners = numberOfOwners;
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
}
