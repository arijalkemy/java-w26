package org.ejercicio.conocesionaria.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class VehicleDTO implements Serializable {
    private UUID id;
    private String brand;
    private String model;
    private LocalDate manufacturingDate;
    private int doors;
    @JsonIgnore
    private List<ServiceDTO> services;
    private double price;
    private String currency;
    private int countOfOwners;
}
