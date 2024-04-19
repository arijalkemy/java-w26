package org.example.concesionario.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Data
public class VehicleEntity {
    private UUID id;
    private String brand;
    private String model;
    private LocalDate manufacturingDate;
    private Long numberOfKm;
    private int doors;
    private double price;
    private String currency;
    private List<ServicesEntity> services;
    private int countOfOwners;


    public VehicleEntity(UUID id, String brand, String model, LocalDate manufacturingDate,
                         Long numberOfKm, int doors, double price, String currency,
                         List<ServicesEntity> services, int countOfOwners) {
        this.id = UUID.randomUUID();
        this.brand = brand;
        this.model = model;
        this.manufacturingDate = manufacturingDate;
        this.numberOfKm = numberOfKm;
        this.doors = doors;
        this.price = price;
        this.currency = currency;
        this.services = services;
        this.countOfOwners = countOfOwners;
    }
}
