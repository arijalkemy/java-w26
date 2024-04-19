package com.meli.concesionaria.dto;

public class ResponseVehicleDto {
    private String brand;
    private String model;
    private String manufacturingDate;
    private  Integer numberOfKilometers;
    private  Integer doors;
    private  Integer price;
    private  String currency;

    public ResponseVehicleDto(String brand, String model, String manufacturingDate, Integer numberOfKilometers, Integer doors, Integer price, String currency) {
        this.brand = brand;
        this.model = model;
        this.manufacturingDate = manufacturingDate;
        this.numberOfKilometers = numberOfKilometers;
        this.doors = doors;
        this.price = price;
        this.currency = currency;
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

    @Override
    public String toString() {
        return "ResponseVehicleDto{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", manufacturingDate='" + manufacturingDate + '\'' +
                ", numberOfKilometers=" + numberOfKilometers +
                ", doors=" + doors +
                ", price=" + price +
                ", currency='" + currency + '\'' +
                '}';
    }
}
