package com.mercadolibre.ConcecionariaAutos.dto;

import com.mercadolibre.ConcecionariaAutos.entity.ServiceVehicle;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehicleDTO {
    private int id;
    private String brand;
    private String model;
    private LocalDate manufacturingDate;
    private int numberOfKilometers;
    private int doors;
    private double price;
    private String currency;
    private List<ServiceVehicle> services;
    private int countOfOwners;
}
