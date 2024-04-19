package com.example.concesionario.dto;

import com.example.concesionario.entity.Service;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehiculoSinServiceDTO {
    private String brand;
    private String model;
    private LocalDate manufactoringDate;
    private int numbersOfKilometers;
    private int doors;
    private double price;
    private String currency;
    private int countOfOwners;
}
