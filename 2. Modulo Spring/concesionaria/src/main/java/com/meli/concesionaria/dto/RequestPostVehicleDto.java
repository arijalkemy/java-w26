package com.meli.concesionaria.dto;

import com.meli.concesionaria.entity.Service;

import java.util.List;

public class RequestPostVehicleDto {
    private String brand;
    private String model;
    private String manufacturingDate;
    private  Integer numberOfKilometers;
    private  Integer doors;
    private  Integer price;
    private  String currency;
    private List<Service> services;

    public RequestPostVehicleDto(String brand, String model, String manufacturingDate, Integer numberOfKilometers, Integer doors, Integer price, String currency, List<Service> services) {
        this.brand = brand;
        this.model = model;
        this.manufacturingDate = manufacturingDate;
        this.numberOfKilometers = numberOfKilometers;
        this.doors = doors;
        this.price = price;
        this.currency = currency;
        this.services = services;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public String getManufacturingDate() {
        return manufacturingDate;
    }

    public Integer getNumberOfKilometers() {
        return numberOfKilometers;
    }

    public Integer getDoors() {
        return doors;
    }

    public Integer getPrice() {
        return price;
    }

    public String getCurrency() {
        return currency;
    }

    public List<Service> getServices() {
        return services;
    }

    @Override
    public String toString() {
        return "RequestPostVehicleDto{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", manufacturingDate='" + manufacturingDate + '\'' +
                ", numberOfKilometers=" + numberOfKilometers +
                ", doors=" + doors +
                ", price=" + price +
                ", currency='" + currency + '\'' +
                ", services=" + services +
                '}';
    }
}
