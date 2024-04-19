package org.ejercicio.conocesionaria.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
public class Vehicle {
    private UUID id;
    private String brand;
    private String model;
    private LocalDate manufacturingDate;
    private int doors;
    private double price;
    private String currency;
    private List<Service> services;
    private int countOfOwners;

    public Vehicle(String brand, String model, LocalDate manufacturingDate, int doors, double price, String currency,
                   List<Service> services, int countOfOwners) {
        this.id = UUID.randomUUID();
        this.brand = brand;
        this.model = model;
        this.manufacturingDate = manufacturingDate;
        this.doors = doors;
        this.price = price;
        this.currency = currency;
        this.services = services;
        this.countOfOwners = countOfOwners;
    }

    public Vehicle() {
        this.id = UUID.randomUUID();
    }
}
