package org.example.concesionaria.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
public class VehiclePostRequestDTO {
    String brand;
    String model;
    LocalDate manufacturingDate;
    String numberOfKilometers;
    String doors;
    String price;
    String currency;
    List<ServiceDTO> services;
    String countOfOwners;
}
