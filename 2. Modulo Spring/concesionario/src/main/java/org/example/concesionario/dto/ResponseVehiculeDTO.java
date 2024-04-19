package org.example.concesionario.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResponseVehiculeDTO {
    private String brand;
    private String model;
    private LocalDate manufacturingDate;
    private Long numberOfKm;
    private int doors;
    private double price;
    private String currency;
    private int countOfOwners;
}
