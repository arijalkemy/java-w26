package org.miprimerproyecto.consesionariaautos.model;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class Vehicle {
    int id;
    String brand;
    String model;
    String manufacturingDate;
    int numerOfKilometers;
    int doors;
    int price;
    String currency;
    List<Services> listServices;
    int countOfOwners;

    public Vehicle(int id, String brand, String model, String manufacturingDate, int numerOfKilometers, int doors, int price,
                   String currency, List<Services> listServices, int countOfOwners) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.manufacturingDate = manufacturingDate;
        this.numerOfKilometers = numerOfKilometers;
        this.doors = doors;
        this.price = price;
        this.currency = currency;
        this.listServices = listServices;
        this.countOfOwners = countOfOwners;
    }
}
