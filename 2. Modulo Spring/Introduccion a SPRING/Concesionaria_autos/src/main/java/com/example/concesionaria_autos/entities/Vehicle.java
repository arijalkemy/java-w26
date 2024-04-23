package com.example.concesionaria_autos.entities;

import com.example.concesionaria_autos.dto.ServiceDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Vehicle {
    @JsonIgnore
    private UUID id;
    private String brand;
    private String model;
    private String manufacturingDate;
    private Integer numberOfKilometers;
    private Integer doors;
    private Double price;
    private String currency;
    @JsonIgnore
    private List<Service> services;
    private Integer countOfOwners;
}
