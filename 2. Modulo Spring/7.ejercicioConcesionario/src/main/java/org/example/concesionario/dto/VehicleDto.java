package org.example.concesionario.dto;

import lombok.Data;
import org.example.concesionario.model.Service;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

@Data
public class VehicleDto {
    private String brand;
    private String model;
    @DateTimeFormat(
            pattern = "yyyy-MM-dd"
    )
    private LocalDate manufacturing;
    private int numberOfKilometers;
    private int doors;
    private double price;
    private String currency;
    private int numberOfOwners;
    private List<Service> service;
}
