package org.example.integradorconcessionaire.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.example.integradorconcessionaire.entity.VehicleService;

import java.time.LocalDate;
import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
public class VehicleResponseDTO {

    private String brand;
    private String model;
    private LocalDate manufacturingDate;
    private double numberOfKilometers;
    private int doors;
    private double price;
    private String currency;
    private int countOfOwners;

}
