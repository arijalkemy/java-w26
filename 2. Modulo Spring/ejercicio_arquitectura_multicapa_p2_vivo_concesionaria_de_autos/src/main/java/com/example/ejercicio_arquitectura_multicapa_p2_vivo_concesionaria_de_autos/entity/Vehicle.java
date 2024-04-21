package com.example.ejercicio_arquitectura_multicapa_p2_vivo_concesionaria_de_autos.entity;

import java.util.List;

public class Vehicle {
    private int id;
    private String brand;
    private String model;
    private String manufacturingDate;
    private String numberOfKilometers;
    private String doors;
    private String price;
    private String currency;
    private List<Service> services;
    private String countOfOwners;

    public Vehicle() { }

    public Vehicle(int id, String brand, String model, String manufacturingDate, String numberOfKilometers, String doors, String price, String currency, List<Service> services, String countOfOwners) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.manufacturingDate = manufacturingDate;
        this.numberOfKilometers = numberOfKilometers;
        this.doors = doors;
        this.price = price;
        this.currency = currency;
        this.services = services;
        this.countOfOwners = countOfOwners;
    }

    public String getBrand() {
        return brand;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getManufacturingDate() {
        return manufacturingDate;
    }

    public void setManufacturingDate(String manufacturingDate) {
        this.manufacturingDate = manufacturingDate;
    }

    public String getNumberOfKilometers() {
        return numberOfKilometers;
    }

    public void setNumberOfKilometers(String numberOfKilometers) {
        this.numberOfKilometers = numberOfKilometers;
    }

    public String getDoors() {
        return doors;
    }

    public void setDoors(String doors) {
        this.doors = doors;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public List<Service> getServices() {
        return services;
    }

    public void setServices(List<Service> services) {
        this.services = services;
    }

    public String getCountOfOwners() {
        return countOfOwners;
    }

    public void setCountOfOwners(String countOfOwners) {
        this.countOfOwners = countOfOwners;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
            "id=" + id +
            ", brand='" + brand + '\'' +
            ", model='" + model + '\'' +
            ", manufacturingDate='" + manufacturingDate + '\'' +
            ", numberOfKilometers='" + numberOfKilometers + '\'' +
            ", doors='" + doors + '\'' +
            ", price='" + price + '\'' +
            ", currency='" + currency + '\'' +
            ", services=" + services +
            ", countOfOwners='" + countOfOwners + '\'' +
            '}';
    }
}
