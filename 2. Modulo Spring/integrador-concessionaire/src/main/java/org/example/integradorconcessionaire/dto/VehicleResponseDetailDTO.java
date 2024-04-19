package org.example.integradorconcessionaire.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.example.integradorconcessionaire.entity.VehicleService;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
public class VehicleResponseDetailDTO {

    private String brand;
    private String model;
    private LocalDate manufacturingDate;
    private double numberOfKilometers;
    private int doors;
    private double price;
    private String currency;
    private List<VehicleService> vehicleServices;
    private int countOfOwners;

    public VehicleResponseDetailDTO(){}
}
