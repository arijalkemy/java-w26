package com.example.vehiculo.entity;
import lombok.Getter;
import lombok.Setter;
import java.util.List;
import java.util.ArrayList;
@Setter
@Getter
public class Vehiculo {
    private String brand;
    private String model;
    private String manufacturingDate;
    private int numberOfKilometers;
    private int doors;
    private double price;
    private String currency;
    /*private List<ServicesV> services = new ArrayList<>();*/
    private int countOfOwners;

    public void Vehiculo(String brand, String model, String manufacturingDate, int numberOfKilometers, int doors, double price, String currency, int countOfOwners) {
        this.brand = brand;
        this.model = model;
        this.manufacturingDate = manufacturingDate;
        this.numberOfKilometers = numberOfKilometers;
        this.doors = doors;
        this.price = price;
        this.currency = currency;
        this.countOfOwners = countOfOwners;
    }

}
