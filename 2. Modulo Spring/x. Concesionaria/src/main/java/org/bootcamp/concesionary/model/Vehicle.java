package org.bootcamp.concesionary.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
public class Vehicle {
    private UUID id;
    private String brand;
    private String model;
    private String manufacturingDate;
    private Integer numberOfKilometers;
    private String doors;
    private Integer price;
    private String currency;
    private List<Service> services;
    private String countOfOwners;


}
