package org.example.concesionaria.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;


@Setter
@Getter
@ToString
public class Vehicle {
    private UUID id;
    private String brand;
    private String model;
    private LocalDate manufacturingDate;
    private String numberOfKilometers;
    private String doors;
    private String price;
    private String currency;
    private List<Service> services;
    private String countOfOwners;


    public Vehicle() {
        id = UUID.randomUUID();
    }
}
