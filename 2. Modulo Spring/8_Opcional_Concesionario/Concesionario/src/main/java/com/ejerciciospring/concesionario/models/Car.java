package com.ejerciciospring.concesionario.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Car {
    private Integer id;
    private String brand;
    private String model;
    private LocalDate manufacturingDate;
    private Integer numberOfKilometers;
    private Integer doors;
    private Double price;
    private List<Service> services;
    private Integer countOfOwners;
}
