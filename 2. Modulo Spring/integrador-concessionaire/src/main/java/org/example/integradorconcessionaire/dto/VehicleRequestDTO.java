package org.example.integradorconcessionaire.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.example.integradorconcessionaire.entity.VehicleService;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
public class VehicleRequestDTO {

    private String brand;
    private String model;
    private String manufacturingDate;
    private double numberOfKilometers;
    private int doors;
    private double price;
    private String currency;
    private List<VehicleService> services;
    private int countOfOwners;

}
