package org.ejercicio.conocesionaria.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class VehicleResponseDTO implements Serializable {
    private UUID id;
    private String brand;
    private String model;
    private LocalDate manufacturingDate;
    private int doors;
    private double price;
    private String currency;
    private int countOfOwners;
}
